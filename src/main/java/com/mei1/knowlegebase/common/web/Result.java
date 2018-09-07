package com.mei1.knowlegebase.common.web;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Result<T> {

	private static <M> Result<M> create() {
		return new Result<M>();
	}

	private static <M> Result<M> create(M data) {
		return new Result<M>(data);
	}

	public static <M> Result<M> failure() {
		Result<M> result = create();
		return result;
	}
	
	public static <M> Result<M> failure(int code) {
		Result<M> result = create();
		result.code(code);
		return result;
	}
	
	public static <M> Result<M> failure(int code, Object... args) {
		Result<M> result = create();
		result.code(code);
		result.args = args;
		return result;
	}
	
	public static <M> Result<M> failure(Throwable e, int code, Object... args) {
		Result<M> result = create();
		result.code(code);
		result.exception(e);
		result.args = args;
		return result.exception(e);
	}

	public static <M> Result<M> failure(String message) {
		Result<M> result = create();
		result.message(message);
		return result;
	}
	
	public static <M> Result<M> failure(String message, int code) {
		Result<M> result = create();
		result.message(message);
		return result.code(code);
	}
	
	public static <M> Result<M> failure(String message, Throwable e, int code) {
		Result<M> result = failure(message, code);
		return result.exception(e);
	}

	public static <M> Result<M> ok() {
		Result<M> result = create();
		return result.success();
	}

	public static <M> Result<M> ok(M data) {
		return create(data).success();
	}

	public static <M> Result<M> success(Class<M> clazz) {
		return new Result<M>(clazz).success();
	}

	public static <M> Result<M> success(String message) {
		Result<M> result = ok();
		return result.message(message);
	}

	public static <M> Result<M> success(String message, M data) {
		return ok(data).message(message);
	}

	private boolean success;
	private String message;
	private T data;
	private Integer code;
	private String e;

	/**
	 * 附加值
	 */
	private Object value;
	/**
	 * error code 参数，仅在格式化消息时使用 (不提供set方法)
	 */
	private Object[] args;

	private Result() {
	}

	private Result(T data) {
		this.data = data;
	}

	private Result(Class<T> clazz) {
	}

	public Result<T> success() {
		this.success = true;
		return this;
	}

	public Result<T> code(int code) {
		this.code = code;
		return this;
	}

	public Result<T> message(String message) {
		this.message = message;
		return this;
	}

	public Result<T> data(T data) {
		this.data = data;
		return this;
	}

	public Result<T> value(Object value) {
		this.value = value;
		return this;
	}

	public Result<T> exception(Throwable e) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(bos));
		this.e = bos.toString();
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public Integer getCode() {
		return code;
	}

	public String getE() {
		return e;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setE(String e) {
		this.e = e;
	}

	public Result<T> clearData() {
		this.data = null;
		return this;
	}

	public Object[] getArgs() {
		return args;
	}

	/**
	 * args 只做为errorCode对应消息的参数，不作返回结果使用
	 * 
	 * @param args
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Result [");
		sb.append("success=").append(success);
		if (code != null) {
			sb.append(",\"code\":").append(code);
		}
		if (message != null && message.length() > 0) {
			sb.append(",message=").append(message);
		}
		if (e != null && e.length() > 0) {
			sb.append(",e=").append(e);
		}
		if (data != null) {
			sb.append(",data=").append(data);
		}
		sb.append("]");
		return sb.toString();
	}

	public String simpleJson() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"success\":").append(success);
		if (code != null) {
			sb.append(",\"code\":").append(code);
		}
		if (message != null && message.length() > 0) {
			sb.append(",\"message\":\"").append(message).append("\"");
		}
		if (e != null && e.length() > 0) {
			sb.append(",\"e\":\"").append(e).append("\"");
		}
		if (data != null) {
			sb.append(",\"data\":\"").append(data).append("\"");
		}
		sb.append("}");
		return sb.toString();
	}

}
