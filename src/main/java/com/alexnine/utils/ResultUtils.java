package com.alexnine.utils;


import java.util.Calendar;

/**
 * @author alexnine
 */
public class ResultUtils {

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param message
     * @param object
     * @return
     */
    public static <T> Result success(String message, T object) {
        return generalMethod(ResultCodeEnum.SUCCESS.getCode(), message, object);
    }

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param object
     * @return
     */
    public static <T> Result success(T object) {
        return generalMethod(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), object);
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @return
     */
    public static Result error(String message) {
        return generalMethod(ResultCodeEnum.BUSINESS_ERROR.getCode(), message, null);
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @return
     */
    public static <T> Result error( String message, T object) {
        return generalMethod(ResultCodeEnum.BUSINESS_ERROR.getCode(), message, object);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code, String message) {
        return generalMethod(code, message, null);
    }

    /**
     * 自定义错误信息及回传信息
     *
     * @param code
     * @param message
     * @param object
     * @param <T>
     * @return
     */
    public static <T> Result error(Integer code, String message, T object) {
        return generalMethod(code, message, object);
    }

    /**
     * 返回异常信息，在已知的范围内
     *
     * @param codeEnum
     * @return
     */
    public static Result error(ResultCodeEnum codeEnum) {
        return generalMethod(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    /**
     * 返回异常信息，在已知的范围内
     *
     * @param codeEnum
     * @return
     */
    public static <T> Result error(ResultCodeEnum codeEnum, T object) {
        return generalMethod(codeEnum.getCode(), codeEnum.getMessage(), object);
    }

    /**
     * 通用方法
     *
     * @param code
     * @param message
     * @param object
     * @param <T>
     * @return
     */
    private static <T> Result generalMethod(Integer code, String message, T object) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setTimestamp(Calendar.getInstance().getTimeInMillis());
        result.setMessage(message);
        result.setData(object);
        return result;
    }
}
