package com.vlad.alpha1.controller;

import com.vlad.alpha1.model.AlphaUser;
import com.vlad.alpha1.service.AlphaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlphaController {

    private AlphaUserService alphaUserService;

    @Autowired
    public AlphaController(AlphaUserService alphaUserService) {
        this.alphaUserService = alphaUserService;
    }

    //пусть методы будут подписаны, мол, исключения кидают, необработанно, в логах то они все равно не нужны,
    // такие то нужны только для того, чтоб пользователю показать

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public List<AlphaUser> findAll() {
        return alphaUserService.findAll();
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public AlphaUser auth(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password) throws Exception {
        return alphaUserService.getUserByLoginPassword(login, password);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AlphaUser add(@RequestParam(value = "login") String login,
                         @RequestParam(value = "password") String password) throws Exception {
        return alphaUserService.addUser(login, password);
    }

    @RequestMapping(value = "/ban", method = RequestMethod.PUT)
    public AlphaUser ban(@RequestParam(value = "id") Long id) throws Exception {
        return alphaUserService.banUser(id);
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT)
    public AlphaUser upd(@RequestParam(value = "oldlogin") String oldLogin,
                         @RequestParam(value = "oldpassword") String oldPassword,
                         @RequestParam(value = "newlogin") String newLogin,
                         @RequestParam(value = "newpassword") String newPassword) throws Exception {
        return alphaUserService.updateLoginPassword(oldLogin, oldPassword, newLogin, newPassword);
    }

}
