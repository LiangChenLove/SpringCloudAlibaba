package com.itea.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: cy
 * @Description:
 * @Date 14:52 2022/5/7
 */
@Data
@NoArgsConstructor  //无参构造器
@AllArgsConstructor // 有参构造器
public class CommonResponse<T> implements Serializable {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T Data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
