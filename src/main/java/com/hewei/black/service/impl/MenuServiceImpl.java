package com.hewei.black.service.impl;
import com.hewei.black.entity.Menu;
import com.hewei.black.mapper.MenuMapper;
import com.hewei.black.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  服务接口实现类
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
