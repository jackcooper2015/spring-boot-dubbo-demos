package com.reapal.dubbo.provider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.reapal.dubbo.api.model.User;
import com.reapal.dubbo.api.model.UserRole;
import com.reapal.dubbo.api.service.UserRoleService;
import com.reapal.dubbo.provider.mapper.UserRoleMapper;

import java.util.List;

/**
 * @author jack-cooper
 * @since 2016-01-31 21:42
 */
@Service(version = "1.0.0",retries = 0,timeout = 60000)
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements UserRoleService {

    public List<UserRole> getRoleByUser(User user){
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        return baseMapper.selectList(new EntityWrapper<UserRole>(userRole));
    }

}
