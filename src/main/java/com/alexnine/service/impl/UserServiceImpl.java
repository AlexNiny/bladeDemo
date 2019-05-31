package com.alexnine.service.impl;

import com.alexnine.auth.JwtUtils;
import com.alexnine.config.ConKeys;
import com.alexnine.dao.UserDao;
import com.alexnine.entity.User;
import com.alexnine.service.UserService;
import com.alexnine.utils.Result;
import com.alexnine.utils.ResultUtils;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author AlexNine
 * Date 2019/5/31 15:03
 */
@Bean
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public Result authLogin(String username, String password) {
        User u = userDao.findByNameAndPwd(username, DigestUtils.md5Hex(password + ConKeys.PWD_SALT));
        if (u == null) {
            return ResultUtils.error("登录失败，请检查用户名或者密码");
        } else {
            return ResultUtils.success(JwtUtils.getToken(u));
        }
    }
}
