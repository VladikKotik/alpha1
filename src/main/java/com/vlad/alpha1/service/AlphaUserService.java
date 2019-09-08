package com.vlad.alpha1.service;

import com.vlad.alpha1.Model.AlphaUser;

import java.util.List;

public interface AlphaUserService {
    AlphaUser addUser(String login, String password);
    AlphaUser updateLoginPassword(Long id, String login, String password);
    AlphaUser banUser(Long id);
    AlphaUser getUserByLoginPassword(String login, String password);
    List<AlphaUser> findAll();
}
