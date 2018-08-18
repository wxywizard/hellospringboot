package com.wxywizard.domain.exception;


import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author wxywizard
 * @param <T>
 *  2018-08-08
 */
@Data
public class Result<T> {

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;
}
