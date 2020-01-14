package com.hewei.black.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hewei.black.common.BaseResult;
import com.hewei.black.entity.RoleMenu;
import com.hewei.black.query.BaseQuery;
import com.hewei.black.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;


import java.util.Locale;

/**
* 
*/
@RestController
@RequestMapping("/roleMenu")
@Api(value = "接口")
public class RoleMenuController {

                
    @Autowired
    private IRoleMenuService iRoleMenuService;

    @Autowired
    private MessageSource messageSource;

    /**
     * 列表
     */
    @GetMapping
    //@RequiresPermissions("roleMenu:list" )
    @ApiOperation(value = "获取列表" )
    public BaseResult<Page<RoleMenu>> list(BaseQuery baseQuery){
        BaseResult<Page<RoleMenu>> baseResult = new BaseResult<>();
        //查询列表数据
        Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
        Page pageList=iRoleMenuService.selectPage(page,new EntityWrapper<RoleMenu>());
        if (CollectionUtils.isEmpty(pageList.getRecords())) {
            return baseResult.notFound();
        }
        baseResult.setData(pageList);
        return baseResult;
    }

    /**
     * 信息
     */
    @GetMapping("/{id}" )
    //@RequiresPermissions("roleMenu:info" )
    @ApiOperation(value = "获取详情信息" )
    public BaseResult<RoleMenu> info(@PathVariable("id" ) Integer id){
        BaseResult<RoleMenu> baseResult = new BaseResult<>();

        RoleMenu roleMenu = iRoleMenuService.selectById(id);
        if (roleMenu == null) {
            return baseResult.notFound();
        }
        baseResult.setData(roleMenu);
        return baseResult;
    }

    /**
     * 保存
     */
    @PostMapping
    //@RequiresPermissions("roleMenu:save" )
    @ApiOperation(value = "新增信息" )
    public BaseResult save(@RequestBody  RoleMenu roleMenu){

        BaseResult<RoleMenu> baseResult = new BaseResult<>();

        boolean retFlag = iRoleMenuService.insert(roleMenu);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        baseResult.setData(roleMenu);
        return baseResult;
    }

    /**
     * 修改
     */
    @PutMapping
    //@RequiresPermissions("roleMenu:update" )
    @ApiOperation(value = "修改信息" )
    public BaseResult update(@RequestBody @PathVariable("roleMenu" ) RoleMenu roleMenu){
        BaseResult<RoleMenu> baseResult = new BaseResult<>();

        boolean retFlag = iRoleMenuService.updateById(roleMenu);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        baseResult.setData(roleMenu);
        return baseResult;
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}" )
    //@RequiresPermissions("roleMenu:delete" )
    @ApiOperation(value = "删除信息" )
    public BaseResult delete(@PathVariable("id" ) Integer id){
        BaseResult<RoleMenu> baseResult = new BaseResult<>();
        boolean retFlag = iRoleMenuService.deleteById(id);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        return baseResult;
    }
}
