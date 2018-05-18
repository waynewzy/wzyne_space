package com.wayne.service;

import com.wayne.dao.UserMapper;
import com.wayne.model.User;
import com.wayne.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wayne
 * @date 2018/5/17 0017 上午 10:26
 * <p>
 * description:
 */
@Service("userService")
@com.alibaba.dubbo.config.annotation.Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
