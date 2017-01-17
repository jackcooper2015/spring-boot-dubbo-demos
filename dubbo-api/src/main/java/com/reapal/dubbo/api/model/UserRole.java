package com.reapal.dubbo.api.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * Created by jack-cooper on 2017/1/15.
 */
public class UserRole extends BaseEntity {

    private String role;
    private Long userId;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                ", userId=" + userId +
                '}';
    }
}
