package com.alexnine.service;

import com.alexnine.utils.Result;
import com.alexnine.entity.User;
import com.alexnine.utils.ResultUtils;
import com.blade.ioc.annotation.Bean;

import java.util.List;

import static io.github.biezhi.anima.Anima.select;

/**
 * @author alexnine
 * Date 2019/5/30 17:42
 */
@Bean
public class MyService {

    public Result queryUser() {
        List<User> list = select().bySQL(User.class, "Select * from user").all();
        return ResultUtils.success(list);
    }

}
