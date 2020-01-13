package com.hewei.black.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hewei.black.entity.User;

import com.hewei.black.query.BaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import service.IUserService;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.hewei.black.common.BaseResult;

import java.util.Locale;

/**
* 
*/
@RestController
@RequestMapping("/user")
@Api(value = "接口")
public class UserController {

                


    @Autowired
    private MessageSource messageSource;
    @Autowired
    private IUserService iUserService;
    /**
     * 列表
     */
    @GetMapping
    //@RequiresPermissions("user:list" )
    @ApiOperation(value = "获取列表" )
    public BaseResult<Page<User>>  list(BaseQuery baseQuery){
        BaseResult<Page<User>> baseResult = new BaseResult<>();
        //查询列表数据
        Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
        Page pageList=iUserService.selectPage(page,new EntityWrapper<User>());
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
    //@RequiresPermissions("user:info" )
    @ApiOperation(value = "获取详情信息" )
    public BaseResult<User> info(@PathVariable("id" ) String id){
        BaseResult<User> baseResult = new BaseResult<>();

        User user = iUserService.selectById(id);
        if (user == null) {
            return baseResult.notFound();
        }
        baseResult.setData(user);
        return baseResult;
    }

    /**
     * 保存
     */
    @PostMapping
    //@RequiresPermissions("user:save" )
    @ApiOperation(value = "新增信息" )
    public BaseResult save(@RequestBody  User user){

        BaseResult<User> baseResult = new BaseResult<>();

        boolean retFlag = iUserService.insert(user);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        baseResult.setData(user);
        return baseResult;
    }

    /**
     * 修改
     */
    @PutMapping
    //@RequiresPermissions("user:update" )
    @ApiOperation(value = "修改信息" )
    public BaseResult update(@RequestBody @PathVariable("user" ) User user){
        BaseResult<User> baseResult = new BaseResult<>();

        boolean retFlag = iUserService.updateById(user);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        baseResult.setData(user);
        return baseResult;
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}" )
    //@RequiresPermissions("user:delete" )
    @ApiOperation(value = "删除信息" )
    public BaseResult delete(@PathVariable("id" ) String id){
        BaseResult<User> baseResult = new BaseResult<>();
        boolean retFlag = iUserService.deleteById(id);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        return baseResult;
    }
}
