package com.gs.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author gongsong
 * @description
 * @date 2020-11-17 22:02
 */
@Slf4j
public class JwtUtil {
    /**
     * 过期时间30分钟
     */
    public static final long EXPIRE_TIME = 1 * 60 * 1000;

    /**
     * 校验token是否正确
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String userName, String secret) {
        try {
            // 根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("userName", userName).build();
            // 效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.info("Token 验证失败，错误信息：{}",e.getMessage());
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 生成签名,5min(分钟)后过期
     * @param userName 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String userName, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带userName信息
            return JWT.create().withClaim("userName", userName).withExpiresAt(date).sign(algorithm);
        } catch (Exception e) {
            log.error("生成签名失败：{}",e.getMessage());
            return "";
        }

    }
}
