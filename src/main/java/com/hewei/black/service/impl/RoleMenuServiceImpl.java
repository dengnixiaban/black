package com.hewei.black.service.impl;
import com.hewei.black.entity.RoleMenu;
import com.hewei.black.mapper.RoleMenuMapper;
import com.hewei.black.service.IRoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  服务接口实现类
 */
@Service
@Transactional
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
