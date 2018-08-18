package com.wxywizard.exception;

import com.wxywizard.enums.ResultEnum;
import lombok.Data;

/**
 * 定义自定义异常类
 * @Author: wxywizard
 */
@Data
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
