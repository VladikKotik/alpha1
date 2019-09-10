package com.vlad.alpha1.service;

import com.vlad.alpha1.Model.AlphaUser;

import java.util.List;

public interface AlphaUserService {
    AlphaUser addUser(String login, String password) throws Exception;
    AlphaUser updateLoginPassword(String oldLogin, String oldPassword, String newLogin, String newPassword) throws Exception;
    AlphaUser banUser(Long id) throws Exception;
    AlphaUser getUserByLoginPassword(String login, String password) throws Exception;
    List<AlphaUser> findAll();
}
