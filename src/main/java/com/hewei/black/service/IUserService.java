package com.hewei.black.service;

import com.baomidou.mybatisplus.service.IService;
import com.hewei.black.entity.User;

import java.util.List;
import java.util.Set;


/**
 *  服务接口
 */
public interface IUserService extends IService<User> {

    Set<String> getRolesByUserName(String username);

    Set<String> getPermissionsByRoles(Set<String> roles);

}
