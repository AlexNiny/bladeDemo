package com.alexnine.exception;

import com.alexnine.utils.ResultCodeEnum;
import com.alexnine.utils.ResultUtils;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.blade.exception.BladeException;
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
        if (e instanceof BladeException){
            renderJsonResponse(WebContext.response(),((BladeException) e).getStatus(),((BladeException) e).getName());
        }else if (e instanceof JWTDecodeException){
            renderJsonResponse(WebContext.response(),ResultCodeEnum.BUSINESS_ERROR.getCode(),"Token解析错误");
        } else {
            renderJsonResponse(WebContext.response(),ResultCodeEnum.BUSINESS_ERROR.getCode(),e.toString());
        }
        e.printStackTrace();
    }

    /**
     * 将异常信息渲染成JSON返回
     * @param response response对象
     */
    private void renderJsonResponse(Response response,Integer code,String message) {
        response.json(ResultUtils.error(code, message));
    }
}
