package com.alexnine.hook;

import com.blade.ioc.annotation.Bean;
import com.blade.mvc.RouteContext;
import com.blade.mvc.hook.WebHook;
import lombok.extern.slf4j.Slf4j;




/**
 * @author AlexNine
 * Date 2019/5/31 9:08
 * Hook类
 */
@Bean
@Slf4j
public class MyWebHook implements WebHook {
    @Override
    public boolean before(RouteContext routeContext) {
        log.info("Request Host:{},Request Path:{}",routeContext.address(),routeContext.uri());
        //拦截请求 做按照需求使用
        String headerValue = routeContext.header("User-Agent");
        return true;
    }
}
