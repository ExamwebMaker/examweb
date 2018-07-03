package com.examweb.group.dto;

import lombok.Data;

/**
 * @Author: Jessiecaicai
 * @Description: 统一的数据格式
 * @Date:Created in 2018/7/2
 */
@Data
public class Result<T> {

    /**
     * 请求是否成功的标识
     */
    private boolean success;

    /**
     * 返回的提示信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 无参构造器
     * Creates a new instance of Result.
     *
     */
    public Result() {
        super();
    }

    /**
     * 含有所有属性的构造器
     * Creates a new instance of Result.
     *
     * @param success
     * @param message
     * @param data
     */
    public Result(boolean success, String message, T data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
