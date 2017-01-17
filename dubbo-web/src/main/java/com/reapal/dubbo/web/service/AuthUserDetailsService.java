package com.reapal.dubbo.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.reapal.dubbo.api.model.User;
import com.reapal.dubbo.api.model.UserRole;
import com.reapal.dubbo.api.service.UserRoleService;
import com.reapal.dubbo.api.service.UserService;
import com.reapal.dubbo.web.util.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jack-cooper on 2017/1/15.
 */

@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Reference(version = "1.0.0")
    private UserService userService;
    @Reference(version = "1.0.0")
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.queryByName(name);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if(user == null){
            throw new UsernameNotFoundException("no user found");
        } else {
            try {
                List<UserRole> roles = userRoleService.getRoleByUser(user);
                return new MyUserDetails(user, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}
