package com.chic.qh.support.web;

public class ResponseBodyWrapper<T>{
    private int code;
    private String message;
    private T data;

    private ResponseBodyWrapper(){}

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseBodyWrapper<T> ok(T data){
        ResponseBodyWrapper wrapper = new ResponseBodyWrapper();
        wrapper.setCode(200);
        wrapper.setData(data);
        wrapper.setMessage("success");
        return wrapper;
    }

    public static ResponseBodyWrapper clientError(int code, String message){
        ResponseBodyWrapper wrapper = new ResponseBodyWrapper();
        wrapper.setCode(code);
        wrapper.setMessage(message);
        return wrapper;
    }

    public static ResponseBodyWrapper serverError(String message){
        ResponseBodyWrapper wrapper = new ResponseBodyWrapper();
        wrapper.setCode(500);
        wrapper.setMessage(message);
        return wrapper;
    }

}
