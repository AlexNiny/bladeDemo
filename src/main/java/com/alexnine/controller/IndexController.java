package com.alexnine.controller;

import com.alexnine.auth.JwtUtils;
import com.alexnine.entity.User;
import com.alexnine.utils.Result;
import com.alexnine.utils.ResultUtils;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;

/**
 * @author AlexNine
 * Date 2019/5/30 15:48
 */
@Path
public class IndexController {


    @GetRoute("/")
    @JSON
    public Result root(Request request) {
        DecodedJWT j = JwtUtils.decodedJWT(request.header("Auth"));
        return ResultUtils.success(new User(
                j.getClaim("id").asLong(),
                j.getClaim("username").asString(),
                "不会告诉你的",
                j.getClaim("role").asString()));
    }

}
