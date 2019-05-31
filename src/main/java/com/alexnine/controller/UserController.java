package com.alexnine.controller;

import com.alexnine.entity.User;
import com.alexnine.service.UserService;
import com.alexnine.utils.Result;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;


/**
 * @author AlexNine
 * Date 2019/5/31 15:02
 */
@Path(value = "/user")
public class UserController {

    @Inject
    private UserService userService;

    @PostRoute("/login")
    @JSON
    public Result authLogin(@BodyParam User user){
        return userService.authLogin(user.getUsername(), user.getPassword());
    }
}
