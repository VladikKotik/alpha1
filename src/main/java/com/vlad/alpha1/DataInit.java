package com.vlad.alpha1;

import com.vlad.alpha1.service.AlphaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private AlphaUserService alphaUserService;

    @Autowired
    public DataInit(AlphaUserService alphaUserService){
        this.alphaUserService=alphaUserService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        alphaUserService.addUser("jora","228");
        alphaUserService.addUser("jora2","229");
        alphaUserService.addUser("nissan","skyline");
        alphaUserService.addUser("toyota","supra");
        alphaUserService.addUser("honda","nsx");
    }
}
