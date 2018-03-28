package com.smile.enums;

/**
 * Created by yaojiulong on 2017/7/26.
 */
public enum  ResultEnums {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PAIMARY_SCHOOL(100, "上小学吧"),
    MIDDLE_SCHOOL(101, "上中学吧")
    ;
    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
