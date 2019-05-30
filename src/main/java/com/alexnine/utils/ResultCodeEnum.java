package com.alexnine.utils;

/**
 * 枚举
 * @author alexnine
 */
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 业务异常
     */
    BUSINESS_ERROR(500, "业务异常");

    /**
     * 状态
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
