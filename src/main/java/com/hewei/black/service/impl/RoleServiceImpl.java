package com.hewei.black.service.impl;
import com.hewei.black.entity.Role;
import com.hewei.black.mapper.RoleMapper;
import com.hewei.black.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  服务接口实现类
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
