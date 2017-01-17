package com.reapal.dubbo.provider.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.reapal.dubbo.api.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author jack-cooper
 * @since 2016-01-22 22:17
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username = #{username}")
    public User queryByName(String username);
}
