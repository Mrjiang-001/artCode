package com.artCode.util;


import java.io.Serializable;

/**
 * 功能描述: 统一的 Response 返回对象
 * @author huanglin
 */
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 196497372528417899L;

    private int code;

    private String msg;

    private T data;

    private T lcdata;

    public ApiResponse() {

    }
    public ApiResponse(T data) {

    }

    public ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResponse(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    public ApiResponse(int code, String msg, T data, T lcdata) {
        this(code, msg);
        this.data = data;
        this.lcdata = lcdata;
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

    public T getLcdata() {
        return lcdata;
    }
    public void setLcdata(T lcdata) {
        this.lcdata = lcdata;
    }


    /***
     * 成功-返回默认信息
     */
    public static ApiResponse<?> success() {
    	return create(Status.SUCCESS);
    }

    /***
     *  新增或修改返回结果
     */
    public static ApiResponse<?> saveSuccess(String type) {

        if("add".equals(type)) {
	   		 return create(Status.SAVESUCCESS);
	   	}else if("update".equals(type)) {
	   		 return create(Status.UPDATESUCCESS);
	   	}else {
	   	 return create(Status.SUCCESS);
	   	}
    }

    /***
     * 操作成功，并返回提示信息
     */
    public static ApiResponse<?> successOfMessage(String msg) {
    	return create(Status.SUCCESS.getCode(), msg);
    }

    /***
     * 操作成功，并返回数据
     */
    public static <T> ApiResponse<T> successOfData(T data) {
        return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
    }

    /***
     *操作成功，根据操作类型并返回数据（新增或修改）
     */
    public static <T> ApiResponse<T> successOfTypeData(T data,String type) {
    	if("add".equals(type)) {
    		 return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SAVESUCCESS.getMsg(), data);
    	}else if("update".equals(type)) {
    		 return new ApiResponse<>(Status.SUCCESS.getCode(), Status.UPDATESUCCESS.getMsg(), data);
    	}else {
    		 return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
    	}
    }

    /***
     *返回两个不同的结果集
     */
    public static <T> ApiResponse<T> successOfLcData(T data,T lcdata) {
        return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data,lcdata);
    }

    /***
     * 提示报错，返回默认错误提示信息
     */
    public static ApiResponse<?> fail() {
        return create(Status.INTERNAL_SERVER_ERROR);
    }

    /***
     * 提示报错，并返回自定义错误提示
     */
    public static ApiResponse<?> failOfMessage(String msg) {
        return create(Status.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static <T> ApiResponse<T> failOfDataMessage(String msg,T data) {
        return create(Status.INTERNAL_SERVER_ERROR.getCode(), msg, data);
    }

    /***
     * 提交参数有误
     */
    public static ApiResponse<?> notValidParam() {
        return create(Status.NOT_VALID_PARAM);
    }

    /***
     * 提示权限不足，拒绝访问
     */
    public static ApiResponse<?> forbidden() {
        return create(Status.FORBIDDEN);
    }

    /***
     * 提示资源找不到（404）
     */
    public static ApiResponse<?> notFound() {
        return create(Status.NOT_FOUND);
    }

    /***
     * 提示未登录（401）
     */
    public static ApiResponse<?> notLogin() {
        return create(Status.NOT_LOGIN);
    }

    public static ApiResponse<?> create(int code, String msg) {
        return new ApiResponse<>(code, msg);
    }

    public static <T> ApiResponse<T> create(int code, String msg,T data) {
        return new ApiResponse<>(code, msg,data);
    }

    private static ApiResponse<?> create(Status status) {
        return create(status.getCode(), status.getMsg());
    }

}
