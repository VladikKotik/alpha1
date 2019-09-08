package com.vlad.alpha1.Controller;

import com.vlad.alpha1.Model.AlphaUser;
import com.vlad.alpha1.service.AlphaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlphaController {

    private AlphaUserService alphaUserService;

    @Autowired
    public AlphaController(AlphaUserService alphaUserService){
        this.alphaUserService=alphaUserService;
    }

    @RequestMapping("/allusers")
    public List<AlphaUser> findAll() {
        return alphaUserService.findAll();
    }

    @RequestMapping("/auth")
    public AlphaUser auth(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password) {
        return alphaUserService.getUserByLoginPassword(login, password);
    }

    @RequestMapping("/add")
    public AlphaUser add(@RequestParam(value = "login") String login,
                         @RequestParam(value = "password") String password) {
        return alphaUserService.addUser(login,password);
    }

    @RequestMapping("/ban")
    public AlphaUser ban(@RequestParam(value = "id")Long id){
        return alphaUserService.banUser(id);
    }

    @RequestMapping("/upd")
    public AlphaUser upd(@RequestParam(value = "id") Long id,
            @RequestParam(value = "newlogin") String newLogin,
            @RequestParam(value = "newpassword") String newPassword) {
        return alphaUserService.updateLoginPassword(id, newLogin,newPassword);
    }
}
