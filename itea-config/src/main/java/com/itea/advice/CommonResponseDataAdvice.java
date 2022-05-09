package com.itea.advice;

import com.itea.annotation.IgnoreResponseAdvice;
import com.itea.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: cy
 * @Description: 实现统一响应
 * @Date 15:02 2022/5/7
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 判断是否要进行响应处理
     */
    @Override
    @SuppressWarnings("all")//不让页面提醒警告， 编码页面看着舒服
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 自定义忽视注解作用的类+方法，不需要处理，直接放行
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        CommonResponse<Object> commonResponse = new CommonResponse<>(0, "");
        if (null == body) {
            return commonResponse;
        } else if (body instanceof CommonResponse) {
            commonResponse = (CommonResponse<Object>) body;
        }else {
            commonResponse.setData(body);
        }
        return commonResponse;
    }

}
