package com.alexnine.auth;

import com.alexnine.entity.User;
import com.alexnine.utils.ResultCodeEnum;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blade.exception.BladeException;
import com.mysql.cj.util.StringUtils;

import static io.github.biezhi.anima.Anima.select;

import java.util.Date;

/**
 * @author AlexNine
 * Date 2019/5/31 14:07
 */
public class JwtUtils {

    private static final String TOKEN_KEY = "AABBCCTTDDALEX12438740XELADDTTCCBBAA";

    /**
     * 通过用户信息生成token
     *
     * @param user 用户
     * @return
     */
    public static String getToken(User user) {
        try {
            Date expireTime = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
            return JWT.create()
                    .withIssuer("BladeServer")
                    .withClaim("username", user.getUsername())
                    .withClaim("id", user.getId())
                    .withClaim("role", user.getRole())
                    .withExpiresAt(expireTime)
                    .sign(Algorithm.HMAC256(TOKEN_KEY));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * 解析Token
     * @param token aka name
     * @return
     */
    public static DecodedJWT decodedJWT(final String token) {
        DecodedJWT jwt = null;
        // 使用了HMAC256加密算法。
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_KEY))
                .withIssuer("BladeServer")
                .build();
        jwt = verifier.verify(token);
        return jwt;
    }


    /**
     * 验证token信息
     * @param token
     * @return
     */
    public static boolean authToken(String token) {
        if (StringUtils.isNullOrEmpty(token)) {
            throw new NullPointerException("token为空");
        } else {
            if (isOverDate(token)) {
                throw new BladeException(ResultCodeEnum.BUSINESS_ERROR.getCode(), "Token已过期");
            } else {
                DecodedJWT jwt = decodedJWT(token);
                User user = select().bySQL(User.class, "Select * from user where id = ? and username = ?",
                        jwt.getClaim("id").asLong(), jwt.getClaim("username").asString()).one();
                return user != null;
            }
        }

    }

    /**
     * 检查是否过期
     *
     * @param token
     * @return
     */
    public static boolean isOverDate(String token) {
        return decodedJWT(token).getExpiresAt().getTime() - System.currentTimeMillis() < 0;
    }
}
