package com.itea.advice;

import com.itea.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: cy
 * @Description:
 * @Date 15:14 2022/5/7
 */
@Slf4j //日志
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class) //设置捕获异常的类型和范围，此处捕获所有异常
    public CommonResponse<String> handlerGlobalException(HttpServletRequest request, Exception e) {
        CommonResponse<String> commonResponse = new CommonResponse<>(-1, "服务器内部异常");
        commonResponse.setData(e.getMessage());
        log.error("服务器异常:[{}]", e.getMessage(), e);
        return commonResponse;
    }
}
