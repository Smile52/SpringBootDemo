package com.smile.handle;

import com.smile.GirlException;
import com.smile.aspect.HttpAspect;
import com.smile.domain.Result;
import com.smile.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**异常捕获类
 * Created by yaojiulong on 2017/7/26.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException exception = (GirlException) e;
            return ResultUtil.error(exception.getCode(), exception.getMessage());
        }else {
            logger.error("系统异常{}", e.getMessage());
            return ResultUtil.error(99,e.getMessage());
        }

    }
}
