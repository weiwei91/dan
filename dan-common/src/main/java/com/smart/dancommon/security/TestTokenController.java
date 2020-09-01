package com.smart.dancommon.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.smart.dancommon.base.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GeneratingTokenController
 * @Author WeiWei10
 * @Date 2020/9/1 14:43
 * @Version 1.0
 */
@RestController
public class TestTokenController {

    /**
     * 过期时间
     **/
    private static final long EXPIRATION = 1800L;//单位为秒
    @PostMapping(value = "/generatingToken")
    public Response<String> GeneratingToken(@RequestBody User user){

        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)// 添加头部
                //可以将基本信息放到claims中
                .withClaim("id", user.getId())//userId
                .withClaim("userName", user.getUsername())//userName
                .withExpiresAt(expireDate) //超时设置,设置过期的日期
                .withIssuedAt(new Date()) //签发时间
                .sign(Algorithm.HMAC256(user.getPassword())); //SECRET加密
        return Response.success(token);
    }

    @PostMapping(value = "verificatieToken")
    public Response<String> verificatieToken(HttpServletRequest httpServletRequest,@RequestBody User user){
        String token = httpServletRequest.getHeader("token");
        // 获取 token 中的 user id
        String userId;
        try {
            DecodedJWT a = JWT.decode(token);
            Map<String, Claim> b = a.getClaims();
            userId = b.get("id").asString();
            //对用户进行相关信息进行验证
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        return Response.success("测试Token");

    }
}
