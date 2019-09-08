package com.vlad.alpha1;

import com.vlad.alpha1.Model.AlphaUser;
import com.vlad.alpha1.repositories.AlphaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private AlphaUserRepository alphaUserRepository;

    @Autowired
    public DataInit(AlphaUserRepository alphaUserRepository){
        this.alphaUserRepository=alphaUserRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        alphaUserRepository.save(new AlphaUser("jora", "228"));
        alphaUserRepository.save(new AlphaUser("jora2", "229"));
        alphaUserRepository.save(new AlphaUser("toyota", "supra"));
        alphaUserRepository.save(new AlphaUser("nissan", "skyline"));
        alphaUserRepository.save(new AlphaUser("honda", "nsx"));

    }
}
