package com.wayne.service.Impl;

import com.wayne.dao.UserMapper;
import com.wayne.model.User;
import com.wayne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wayne
 * @date 2018/5/11 0011
 * <p>
 * description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
