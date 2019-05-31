package com.alexnine.hook;

import com.alexnine.auth.JwtUtils;
import com.blade.Environment;
import com.blade.ioc.annotation.Bean;
import com.blade.mvc.RouteContext;
import com.blade.mvc.WebContext;
import com.blade.mvc.hook.WebHook;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        log.info("Request Host:{},Request Path:{}", routeContext.address(), routeContext.uri());
        //拦截请求 做按照需求使用
        if (!isPass(routeContext.uri())) {
            return JwtUtils.authToken(routeContext.header("Auth"));
        } else {
            return true;
        }
    }

    /**
     * 是否需要做验证
     * @param uri
     * @return
     */
    private boolean isPass(String uri) {
        //dev模式不用验证
        if (WebContext.blade().devMode()) {
            return true;
        } else {
            //是否是白名单
            Map<String, String> argsCof = WebContext.blade().environment().toMap();
            String whitePattern = argsCof.get("app.whitePattern");
            if (StringUtil.isNullOrEmpty(whitePattern)) {
                return false;
            } else {
                Pattern pattern = Pattern.compile(whitePattern);
                Matcher m = pattern.matcher(uri);
                return m.find();
            }
        }
    }
}
