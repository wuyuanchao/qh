package com.chic.qh.domain.core.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class ResponseEntity extends HashMap<String, Object> {
	private static Logger logger = LoggerFactory.getLogger(ResponseEntity.class);
	private static final long serialVersionUID = 1L;

	public final static int SUCCESS = 200; // 成功
	public final static int WARN = 500; // 后端提醒
	public final static int TOKEN_INVALID = 401; // 后端提醒

	public final static String SUCCESSMessage = "success";
	public final static String FAILmessage = "fail";

	public ResponseEntity() {
		put("code", SUCCESS);
	}

	public static ResponseEntity error() {
		return error(WARN, "Server deserted, please try again later");
	}

	public static ResponseEntity error(String message) {
		return error(WARN, message);
	}

	public static ResponseEntity tokenError() {
		return error(TOKEN_INVALID, "Access denied");
	}

	public static ResponseEntity error(int ret, String message) {
		ResponseEntity r = new ResponseEntity();
		r.put("code", ret);
		r.put("message", message);
		printErrorLogResp(r);
		return r;
	}

	private static void printLogResp(ResponseEntity r) {
		//logger.info("R={}\n", JSON.toJSONString(r));
	}
	private static void printErrorLogResp(ResponseEntity r) {
		logger.warn("R={}\n", JSON.toJSONString(r));
	}

	public static ResponseEntity error(int ret, String message, Object data) {
		ResponseEntity r = new ResponseEntity();
		r.put("code", ret);
		r.put("message", message);
		r.put("data", data);
		printErrorLogResp(r);
		return r;
	}

	public static ResponseEntity ok(String message) {
		ResponseEntity r = new ResponseEntity();
		r.put("message", message);
		r.put("code", SUCCESS);
		printLogResp(r);
		return r;
	}

	public static ResponseEntity ok(String message, String obj) {
		ResponseEntity r = new ResponseEntity();
		r.put("message", message);
		r.put("code", SUCCESS);
		r.put("data", obj);
		printLogResp(r);
		return r;
	}

	public static ResponseEntity ok(Object obj) {
		ResponseEntity r = new ResponseEntity();
		r.put("data", obj);
		r.put("message", "success");
		r.put("code", SUCCESS);
		printLogResp(r);
		return r;
	}

	public static ResponseEntity ok(Object obj, String message) {
		ResponseEntity r = new ResponseEntity();
		r.put("data", obj);
		r.put("message", message);
		r.put("code", SUCCESS);
		printLogResp(r);
		return r;
	}

	public static ResponseEntity ok(Map<?, ?> map) {
		ResponseEntity r = new ResponseEntity();
		r.put("data", map);
		r.put("message", "success");
		r.put("ret", SUCCESS);
		printLogResp(r);
		return r;
	}

	public static ResponseEntity ok(List<?> list) {
		ResponseEntity r = new ResponseEntity();
		r.put("data", list);
		r.put("message", "success");
		r.put("code", SUCCESS);
		printLogResp(r);
		return r;
	}

	public static ResponseEntity ok() {
		ResponseEntity r = new ResponseEntity();
		r.put("message", "success");
		r.put("code", SUCCESS);
		printLogResp(r);
		return r;
	}

	public ResponseEntity put(String key, Object value) {
		super.put(key, value);
		return this;
	}


	public <T> T getDataObject(Class<T> clazz) {
		try{
			Object data = super.get("data");
			if (data == null) {
				return null;
			}
			T t = JSON.parseObject(JSON.toJSONString(data), clazz);
			return t;
		}catch (Exception e){
			return null;
		}
	}

}
