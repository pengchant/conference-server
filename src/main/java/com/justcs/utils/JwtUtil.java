package com.justcs.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * jwt的工具类
 */
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 设置4h后过期
     */
    private static final long EXPRIE_TIME = 4 * 60 * 60 * 1000;

    /**
     * 根据用户名，秘钥生成签名
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username, String secret){
        try {
            Date date = new Date(System.currentTimeMillis() + EXPRIE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附加username 信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取token中的信息无需token也能够解密
     * @param token
     * @return
     */
    public static String getUsername(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 验证token是否正确
     * @param token
     * @param username
     * @param secret
     * @return
     */
    public static boolean verify(String token, String username, String secret){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret); // 根据密码生成JWT校验器
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            // 校验token
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            logger.error("验证toke失败...");
        }
        return false;
    }

}
