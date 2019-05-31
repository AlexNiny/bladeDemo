package com.alexnine.controller;

import com.alexnine.utils.Result;
import com.alexnine.service.MyService;
import com.alexnine.utils.ResultUtils;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
/**
 * @author AlexNine
 * Date 2019/5/30 15:48
 */
@Path
public class IndexController {

    @Inject
    private MyService myservice;


    @GetRoute("/")
    @JSON
    public Result root(){
        return ResultUtils.success();
    }

    @GetRoute("/index")
    @JSON
    public Object index(){
        return myservice.queryUser();
    }

}
