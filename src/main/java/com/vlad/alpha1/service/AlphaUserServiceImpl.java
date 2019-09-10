package com.vlad.alpha1.service;

import com.vlad.alpha1.Model.AlphaUser;
import com.vlad.alpha1.repositories.AlphaUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AlphaUserServiceImpl implements AlphaUserService {

    private final AlphaUserRepository alphaUserRepository;

    @Autowired
    public AlphaUserServiceImpl(AlphaUserRepository alphaUserRepository){
        this.alphaUserRepository=alphaUserRepository;
    }

    @Override
    public AlphaUser addUser(String login, String password) throws Exception {
        if(!alphaUserRepository.existsAlphaUserByLogin(login)) {
            log.info("added");
            return alphaUserRepository.save(
                    AlphaUser.builder()
                            .login(login)
                            .password(password)
                            .build());
        }
        else{throw new Exception("user with this login already exists");}
    }

    @Override
    public AlphaUser updateLoginPassword(String oldLogin, String oldPassword, String newLogin, String newPassword) throws Exception {
        AlphaUser user=alphaUserRepository.findByLoginAndPassword(oldLogin,oldPassword).orElseThrow(()->new Exception("no such user"));
        log.info("updated "+user.getLogin());
        user.setLogin(newLogin);
        user.setPassword(newPassword);
        return alphaUserRepository.save(user);
    }

    @Override
    public AlphaUser banUser(Long id) throws Exception {
        AlphaUser user=alphaUserRepository.findById(id).orElseThrow(()->new Exception("no such user"));
        user.setBlocked(true);
        log.info("banned "+user.getLogin());
        return alphaUserRepository.save(user);
    }

    //сначала думал только id возвращать, потом решил вообще юзера целиком
    @Override
    public AlphaUser getUserByLoginPassword(String login, String password) throws Exception {
        return alphaUserRepository.findByLoginAndPassword(login,password).orElseThrow(()->new Exception("no such user"));
    }

    @Override
    public List<AlphaUser> findAll(){
        return alphaUserRepository.findAll();
    }
}
