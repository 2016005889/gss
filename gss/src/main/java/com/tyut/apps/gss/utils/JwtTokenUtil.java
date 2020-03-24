package com.tyut.apps.gss.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    private static String secret = "dict-admin-secret";

    private static Long expiration = 60 * 60 * 24L;


    public static String createJwt(String username) {

        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USERNAME, username);
        claims.put(CLAIM_KEY_CREATED, new Date());

        //指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(expiration);
        ZoneId zone = ZoneId.systemDefault();
        Instant expDapte = localDateTime.atZone(zone).toInstant();

        //创建一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //保存在Payload（有效载荷）中的内容
                .setClaims(claims)
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //设置过期时间
                .setExpiration(Date.from(expDapte))
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, secret);

        return builder.compact();
    }

    /**
     * 解析token，获取到Payload（有效载荷）中的内容，包括验证签名，判断是否过期
     *
     * @param token
     * @return
     */
    public static Claims parseJwt(String token) {
        //得到DefaultJwtParser
        return Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(secret)
                //设置需要解析的token
                .parseClaimsJws(token).getBody();
    }

    public static String getUserNameFromToken(String token) {
        Claims body = Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(secret)
                //设置需要解析的token
                .parseClaimsJws(token).getBody();
        return body.getSubject();
    }


}
