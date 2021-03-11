package com.jasonr.community.service.Impl;

import com.jasonr.community.dao.UserMapper;
import com.jasonr.community.domain.User;
import com.jasonr.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jasonR
 * @date 2021/3/10 11:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
