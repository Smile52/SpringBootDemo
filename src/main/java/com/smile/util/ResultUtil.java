package com.smile.util;

import com.smile.domain.Result;

/**结果处理工具类
 * Created by yaojiulong on 2017/7/25.
 */
public class ResultUtil {

    public static final Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("Success");
        result.setData(object);
        return result;
    }

    public static final Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
