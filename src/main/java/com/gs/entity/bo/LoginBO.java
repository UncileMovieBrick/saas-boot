package com.gs.entity.bo;

/**
 * @author gongsong
 * @description 用户登陆业务对象
 * @date 2020-11-15 23:32
 */
public class LoginBO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
