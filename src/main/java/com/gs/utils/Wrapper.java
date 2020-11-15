package com.gs.utils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 数据返回封装
 * @param <T>
 */
public class Wrapper<T> implements Serializable {


	/**
	 * 成功码.
	 */
	public static final int SUCCESS_CODE = 200;

	/**
	 * 成功信息.
	 */
	public static final String SUCCESS_MESSAGE = "操作成功";

	/**
	 * 错误码.
	 */
	public static final int ERROR_CODE = 500;

	/**
	 * 错误信息.
	 */
	public static final String ERROR_MESSAGE = "内部异常";

	/**
	 * 错误码：参数非法
	 */
	public static final int ILLEGAL_ARGUMENT_CODE_ = 100;

	/**
	 * 错误信息：参数非法
	 */
	public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";

	/**
	 * 代码
	 */
	private int code;

	/**
	 * 信息
	 */
	private String msg;

	/**
	 * 结果数据
	 */
	private T data;

	/**
	 * Instantiates a new wrapper. default code=200
	 */
	public Wrapper() {
		this(SUCCESS_CODE, SUCCESS_MESSAGE);
	}

	public Wrapper(T data) {
		this(SUCCESS_CODE,SUCCESS_MESSAGE,data);
	}

	public Wrapper(T data, String message) {
		this(SUCCESS_CODE,message,data);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public Wrapper(int code, String message) {
		this(code, message, null);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 * @param result  the result
	 */
	public Wrapper(int code, String message, T result) {
		super();
		boolean flag = (null == result || result.equals((Object)null));
		result = flag ? (T) new ArrayList() : result;
		this.code(code).message(message).data(result);
	}

	public Wrapper(Throwable throwable) {
		super();
		this.code(ERROR_CODE).message(throwable.getMessage());
	}


	/**
	 * Sets the 编号 , 返回自身的引用.
	 *
	 * @param code the new 编号
	 *
	 * @return the wrapper
	 */
	private Wrapper<T> code(int code) {
		this.setCode(code);
		return this;
	}


	/**
	 * Sets the 信息 , 返回自身的引用.
	 *
	 * @param message the new 信息
	 *
	 * @return the wrapper
	 */
	private Wrapper<T> message(String message) {
		this.setMsg(message);
		return this;
	}

	/**
	 * Sets the 结果数据 , 返回自身的引用.
	 *
	 * @param result the new 结果数据
	 *
	 * @return the wrapper
	 */
	public Wrapper<T> data(T result) {
		this.setData(result);
		return this;
	}

	public static <T> Wrapper<T> ok(){
		return new Wrapper(Wrapper.SUCCESS_CODE,Wrapper.SUCCESS_MESSAGE);
	}

	public static <T> Wrapper<T> ok(T data){
		return new Wrapper(Wrapper.SUCCESS_CODE,Wrapper.SUCCESS_MESSAGE,data);
	}

	public static <T> Wrapper<T> error(){
		return new Wrapper(Wrapper.ERROR_CODE,Wrapper.ERROR_MESSAGE);
	}

	public static <T> Wrapper<T> error(String msg){
		return new Wrapper(Wrapper.ERROR_CODE,msg);
	}


	public static <T> Wrapper<T> error(T data){
		return new Wrapper(Wrapper.ERROR_CODE,Wrapper.ERROR_MESSAGE,data);
	}

	public static <T> Wrapper<T> error(int code, String msg){
		return new Wrapper(code, msg);
	}

	public static <T> Wrapper<T> paramError(T data){
		return new Wrapper(Wrapper.ERROR_CODE, Wrapper.ILLEGAL_ARGUMENT_MESSAGE, data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
