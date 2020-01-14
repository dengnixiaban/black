package com.hewei.black.controller;
import com.hewei.black.entity.Menu;
import com.hewei.black.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.dingxin.dormitorymanage.common.BaseResult;

/**
* 
*/
@RestController
@RequestMapping("/menu")
@Api(value = "接口")
public class MenuController {

                                
    @Autowired
    private IMenuService iMenuService;

    @Autowired
    private MessageSource messageSource;

    /**
     * 列表
     */
    @GetMapping
    //@RequiresPermissions("menu:list" )
    @ApiOperation(value = "获取列表" )
    public BaseResult<Page<Menu>>  list(BaseQuery baseQuery){
        BaseResult<Page<Menu>> baseResult = new BaseResult<>();
        //查询列表数据
        Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
        Page pageList=iMenuService.selectPage(page,new EntityWrapper<Menu>());
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
    //@RequiresPermissions("menu:info" )
    @ApiOperation(value = "获取详情信息" )
    public BaseResult<Menu> info(@PathVariable("id" ) Integer id){
        BaseResult<Menu> baseResult = new BaseResult<>();

        Menu menu = iMenuService.selectById(id);
        if (menu == null) {
            return baseResult.notFound();
        }
        baseResult.setData(menu);
        return baseResult;
    }

    /**
     * 保存
     */
    @PostMapping
    //@RequiresPermissions("menu:save" )
    @ApiOperation(value = "新增信息" )
    public BaseResult save(@RequestBody  Menu menu){

        BaseResult<Menu> baseResult = new BaseResult<>();

        boolean retFlag = iMenuService.insert(menu);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        baseResult.setData(menu);
        return baseResult;
    }

    /**
     * 修改
     */
    @PutMapping
    //@RequiresPermissions("menu:update" )
    @ApiOperation(value = "修改信息" )
    public BaseResult update(@RequestBody @PathVariable("menu" ) Menu menu){
        BaseResult<Menu> baseResult = new BaseResult<>();

        boolean retFlag = iMenuService.updateById(menu);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        baseResult.setData(menu);
        return baseResult;
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}" )
    //@RequiresPermissions("menu:delete" )
    @ApiOperation(value = "删除信息" )
    public BaseResult delete(@PathVariable("id" ) Integer id){
        BaseResult<Menu> baseResult = new BaseResult<>();
        boolean retFlag = iMenuService.deleteById(id);
        if (!retFlag) {
            return baseResult.failed(messageSource.getMessage("10001", null, Locale.CHINESE));
        }
        return baseResult;
    }
}
