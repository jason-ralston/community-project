package com.jasonr.community.service;

import com.jasonr.community.domain.User;

/**
 * @author jasonR
 * @date 2021/3/10 12:05
 */
public interface UserService {
    public User findUserById(int id);
}
