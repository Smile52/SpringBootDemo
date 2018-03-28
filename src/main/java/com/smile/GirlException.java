package com.smile;

import com.smile.enums.ResultEnums;

/**
 * Created by yaojiulong on 2017/7/26.
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnums resultEnums) {

        super(resultEnums.getMsg());
        this.code= resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
