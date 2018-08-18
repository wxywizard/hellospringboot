package com.wxywizard.handle;

import com.wxywizard.domain.exception.Result;
import com.wxywizard.exception.GirlException;
import com.wxywizard.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常类
 * @Author: wxywizard
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }else{
            log.error("【系统异常】{}",e);
            return ResultUtils.error(-1,"未知错误");
        }
    }

}
