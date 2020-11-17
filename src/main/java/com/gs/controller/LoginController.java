package com.gs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gs.common.CommonConstant;
import com.gs.entity.User;
import com.gs.entity.bo.LoginBO;
import com.gs.service.IUserService;
import com.gs.utils.JwtUtil;
import com.gs.utils.PasswordUtil;
import com.gs.utils.RedisUtil;
import com.gs.utils.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IUserService iUserService;

    /**
     * 用户登陆
     * @param loginBO
     * @return
     */
    @PostMapping("/login")
    public Wrapper login(@RequestBody LoginBO loginBO) {
        String userName = loginBO.getUserName();
        String passWord = loginBO.getPassword();
        // 生成token
        String token = JwtUtil.sign(userName, passWord);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        User user = iUserService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            return Wrapper.error("该用户不存在");
        }

        String userPassword = PasswordUtil.generatePassword(userName,passWord);
        // 判断用户密码和数据库中密码是否一致
        if (!user.getPassword().equals(userPassword)) {
            return Wrapper.error("用户名密码不匹配");
        }
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token,JwtUtil.EXPIRE_TIME / 1000);

        return Wrapper.ok();
    }

    /**
     * 退出登陆
     * @return
     */
    @PostMapping("/logout")
    public Wrapper logout() {
        Subject subject = SecurityUtils.getSubject();
        if (ObjectUtils.isNotEmpty(subject)) {
            subject.logout();
        }
        return Wrapper.ok();
    }

}
