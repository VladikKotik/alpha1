package com.vlad.alpha1.Controller;

import com.vlad.alpha1.Model.AlphaUser;
import com.vlad.alpha1.repositories.AlphaUserRepository;
import com.vlad.alpha1.service.AlphaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlphaController {
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
    @Autowired
    private AlphaUserRepository alphaUserRepository;
    @Autowired
    private AlphaUserService alphaUserService;

//    @Autowired
//    public AlphaController(AlphaUserRepository alphaUserRepository,
//                           AlphaUserService alphaUserService){
//        this.alphaUserRepository=alphaUserRepository;
//        this.alphaUserService=alphaUserService;
//    }


    public void initData() {
        AlphaUser user1 = new AlphaUser("jora", "228");
        AlphaUser user2 = new AlphaUser("jora2", "229");
        alphaUserRepository.save(user1);
        alphaUserRepository.save(user2);


    }

    @RequestMapping("/users")
    public List<AlphaUser> findAll() {
        initData();
        return alphaUserRepository.findAll();
    }


    //    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
//        return new Greeting(counter.incrementAndGet(),String.format(template,name));
//    }

    @RequestMapping("/auth")
    public AlphaUser find(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password) {
        //initData();
        //return alphaUserRepository.findAll();
        return alphaUserRepository.findByLoginAndPassword(login, password);
    }

    @RequestMapping("/add")
    public AlphaUser add() {
        return alphaUserService.addUser("jora3","230");
    }

}
