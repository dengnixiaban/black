package com.hewei.black.service.impl;
import com.hewei.black.entity.UserRole;
import com.hewei.black.mapper.UserRoleMapper;
import com.hewei.black.service.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  服务接口实现类
 */
@Service
@Transactional
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
