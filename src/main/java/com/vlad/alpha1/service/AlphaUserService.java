package com.vlad.alpha1.service;

import com.vlad.alpha1.Model.AlphaUser;

public interface AlphaUserService {
    AlphaUser addUser(String login, String password);
    AlphaUser updateLoginPassword(String login, String password);
    AlphaUser blockUser(Long id);
    Long getUserByLoginPassword(String login, String password);
}
