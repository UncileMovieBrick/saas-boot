package com.gs.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author gongsong
 * @description：
 * @date 2020-11-17 21:55
 */
public class JwtToken implements AuthenticationToken {
    private static final long serialVersionUID = -8451637096112402805L;
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }
    @Override
    public Object getCredentials() {
        return token;
    }
}
