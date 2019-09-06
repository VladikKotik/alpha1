package com.vlad.alpha1.service;

import com.vlad.alpha1.Model.AlphaUser;
import com.vlad.alpha1.repositories.AlphaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaUserServiceImpl implements AlphaUserService {

    private final AlphaUserRepository alphaUserRepository;

    @Autowired
    public AlphaUserServiceImpl(AlphaUserRepository alphaUserRepository){
        this.alphaUserRepository=alphaUserRepository;
    }

    @Override
    public AlphaUser addUser(String login, String password) {
        return alphaUserRepository.save(new AlphaUser(login,password));
    }

    @Override
    public AlphaUser updateLoginPassword(String login, String password) {
        return null;
    }

    @Override
    public AlphaUser blockUser(Long id) {

        return null;
    }

    @Override
    public AlphaUser getUserByLoginPassword(String login, String password) {//сначала думал только id возвращать, потом решил вообще юзера целиком возвращать

        return alphaUserRepository.findByLoginAndPassword(login,password);
    }
}
