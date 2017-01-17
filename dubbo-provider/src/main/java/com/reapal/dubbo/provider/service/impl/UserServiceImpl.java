package com.reapal.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.reapal.dubbo.api.model.User;
import com.reapal.dubbo.api.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.reapal.dubbo.provider.mapper.UserMapper;

/**
 * @author jack-cooper
 * @since 2016-01-31 21:42
 */
@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{

    public User queryByName(String name){
        return baseMapper.queryByName(name);
    }
}
