
package com.hewei.black.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hewei.black.entity.Role;
import com.hewei.black.entity.RoleMenu;
import com.hewei.black.entity.User;
import com.hewei.black.entity.UserRole;
import com.hewei.black.service.IRoleMenuService;
import com.hewei.black.service.IRoleService;
import com.hewei.black.service.IUserRoleService;
import com.hewei.black.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    private String ClassName =this.getClass().getName();

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IRoleMenuService roleMenuService;

    {
        super.setName(ClassName);
    }
        //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        User user=userService.selectOne(new EntityWrapper<User>().eq("username",username));
        // 从数据库或者缓存中获得角色数据
        List<UserRole> list = userRoleService.selectList(new EntityWrapper<UserRole>().eq("user_id",user.getId()));
        Set<String> roles=new HashSet<>();
        list.stream().forEach(s->roles.add(roleService.selectOne(new EntityWrapper<Role>().eq("role_id",s.getRoleId())).getRolename()));

        Set<String> permissions =new HashSet<>();

        //上面的service层方法需要自己写
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}

