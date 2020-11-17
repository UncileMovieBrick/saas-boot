package com.gs.controller;

import com.gs.entity.User;
import com.gs.entity.bo.UserBO;
import com.gs.entity.enums.StatusCdEnum;
import com.gs.service.IUserService;
import com.gs.utils.PasswordUtil;
import com.gs.utils.SnowFlakeUtil;
import com.gs.utils.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongsong
 * @description 用户 Controller
 * @date 2020-11-15 23:31
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/save")
    public Wrapper save(@RequestBody UserBO userBO) {
        User user = new User();
        BeanUtils.copyProperties(userBO,user);
        user.setUserId(SnowFlakeUtil.getId());
        user.setStatusCd(StatusCdEnum.STATUS_CD_0.getType());

        user.setPassword(PasswordUtil.generatePassword(userBO.getUserName(),userBO.getPassword()));

        iUserService.save(user);
        return Wrapper.ok();
    }

}
