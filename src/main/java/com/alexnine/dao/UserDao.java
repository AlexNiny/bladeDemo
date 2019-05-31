package com.alexnine.dao;

import com.alexnine.entity.User;
import com.blade.ioc.annotation.Bean;
import static io.github.biezhi.anima.Anima.select;

/**
 * @author AlexNine
 * Date 2019/5/31 15:04
 */
@Bean
public class UserDao {

    public User findByNameAndPwd(String username, String password) {
        return select().bySQL(User.class, "Select * from user where username=? and password=?", username, password).one();
    }
}
