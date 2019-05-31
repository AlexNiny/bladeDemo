package com.alexnine.exception;

import com.alexnine.utils.Result;
import com.alexnine.utils.ResultCodeEnum;
import com.alexnine.utils.ResultUtils;
import com.alibaba.fastjson.JSON;
import com.blade.kit.json.SampleJsonSerializer;
import com.blade.mvc.WebContext;
import com.blade.mvc.handler.ExceptionHandler;
import com.blade.mvc.http.Response;
import lombok.extern.slf4j.Slf4j;


/**
 * @author AlexNine
 * Date 2019/5/31 10:30
 * 统一异常处理 返回JSON
 */
@Slf4j
public class MyExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception e) {
        //根据自己的需要进行处理
        e.printStackTrace();
        log.error("Exception:{}", e.getMessage());
        renderJsonResponse(WebContext.response(), e);
    }

    /**
     * 将异常信息渲染成JSON返回
     * @param response response对象
     * @param e 异常
     */
    private void renderJsonResponse(Response response, Exception e) {
        Result result = ResultUtils.error(ResultCodeEnum.BUSINESS_ERROR, e.getMessage());
        response.body(JSON.toJSONString(result));
    }
}
