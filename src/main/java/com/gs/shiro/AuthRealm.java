package com.gs.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gs.entity.User;
import com.gs.service.IUserService;
import com.gs.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 认证登录
     * @param token 前端传入的用户信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        log.info("==========认证登陆==========");
        String token = (String) authenticationToken.getCredentials();// 校验token有效性
        // 获取用户名
        String userName = JwtUtil.getUserName(token);
        if (StringUtils.isBlank(userName)) {
            throw new AuthenticationException("Token 无效");
        }
        // 从数据库中查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        User user = iUserService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            throw new UnknownAccountException("账号不存在");
        }
        String realmName = getName();
        // 盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
        /* 封装用户信息，构建 AuthenticationInfo 对象并返回
         参数 1 principal: 用户对象 也可以是用户帐号
         参数 2：credentials: 密码（一般是密文）
         参数 3:realmName : realm 的名字
         */
        AuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(
                        user,user.getPassword(),credentialsSalt,realmName
                );
        return authenticationInfo;
    }


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        // 获取到用户
//        User userInfo = (User)principals.getPrimaryPrincipal();
//        String userName = userInfo.getUserName();
//        // 查询数据库，获取用户信息
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_name",userName);
//        User dbUserInfo = iUserService.getOne(queryWrapper);
//        if (dbUserInfo != null) {
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            Set<String> rolesCollection = new HashSet<>();
//            Set<String> perStringCollection = new HashSet<>();
//            // 拿到这个角色集合
//            Set<RoleEntity> rolesSet = dbUserInfo.getRoles();
//            for (RoleEntity roleEntity:rolesSet) {
//                rolesCollection.add(roleEntity.getRoleName());
//                for (PermissionEntity p:roleEntity.getPermissions()) {
//                    perStringCollection.add(p.getPermissionName());
//                }
//                info.addStringPermissions(perStringCollection);
//            }
//            info.addRoles(rolesCollection);
//            return info;
//        } else {
//            return null;
//        }
        return null;
    }


}
