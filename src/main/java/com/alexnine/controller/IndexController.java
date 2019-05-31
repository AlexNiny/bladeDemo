package com.alexnine.controller;

import com.alexnine.utils.Result;
import com.alexnine.utils.ResultUtils;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;

/**
 * @author AlexNine
 * Date 2019/5/30 15:48
 */
@Path
public class IndexController {


    @GetRoute("/")
    @JSON
    public Result root() {
        return ResultUtils.success("welcome");
    }

}
