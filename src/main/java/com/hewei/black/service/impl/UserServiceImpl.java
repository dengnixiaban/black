package com.hewei.black.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hewei.black.entity.User;
import com.hewei.black.mapper.UserMapper;
import com.hewei.black.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 *  服务接口实现类
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Set<String> getRolesByUserName(String username) {
        return null;
    }

    @Override
    public Set<String> getPermissionsByRoles(Set<String> roles) {
        return null;
    }
}
