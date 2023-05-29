package com.chic.qh.support.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ReturnValueWrapperHandler implements ResponseBodyAdvice {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ResponseBodyWrapper> handleException(HttpClientErrorException e, WebRequest request){
        logger.debug(request.toString(), e);
        HttpStatus statusCode = e.getStatusCode();
        return ResponseEntity
                .status(statusCode)
                .body(ResponseBodyWrapper.clientError(statusCode.value() ,e.getStatusText()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBodyWrapper> handleException(Exception e, WebRequest request){
        logger.error(request.toString(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseBodyWrapper.serverError(e.getMessage()));
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.hasMethodAnnotation(RespWrap.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return ResponseBodyWrapper.ok(body);
    }
}
