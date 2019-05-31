package com.alexnine.service;

import com.alexnine.utils.Result;

/**
 * @author alexnine
 * Date 2019/5/30 17:42
 */
public interface UserService {

    /**
     * 验证登录信息
     * @param username aka name
     * @param password aka name
     * @return
     */
    Result authLogin(String username,String password);
}
