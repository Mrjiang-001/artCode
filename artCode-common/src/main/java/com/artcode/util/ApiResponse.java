package com.artcode.util;


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


    /***
     * 成功-默认返回信息
     * @return
     */
    public static ApiResponse<?> success() {
    	return create(Status.SUCCESS);
    }

    /***
     *
     * @param type
     * @return
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

    public static ApiResponse<?> successOfMessage(String msg) {
    	return create(Status.SUCCESS.getCode(), msg);
    }

    public static <T> ApiResponse<T> successOfData(T data) {
        return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
    }

    public static <T> ApiResponse<T> successOfTypeData(T data,String type) {
    	if("add".equals(type)) {
    		 return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SAVESUCCESS.getMsg(), data);
    	}else if("update".equals(type)) {
    		 return new ApiResponse<>(Status.SUCCESS.getCode(), Status.UPDATESUCCESS.getMsg(), data);
    	}else {
    		 return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data);
    	}

    }
    public static <T> ApiResponse<T> successOfLcData(T data,T lcdata) {
        return new ApiResponse<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMsg(), data,lcdata);
    }
    public static ApiResponse<?> fail() {
        return create(Status.INTERNAL_SERVER_ERROR);
    }

    public static ApiResponse<?> failOfMessage(String msg) {
        return create(Status.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static <T> ApiResponse<T> failOfDataMessage(String msg,T data) {
        return create(Status.INTERNAL_SERVER_ERROR.getCode(), msg, data);
    }

    public static ApiResponse<?> notValidParam() {
        return create(Status.NOT_VALID_PARAM);
    }

    public static ApiResponse<?> forbidden() {
        return create(Status.FORBIDDEN);
    }

    public static ApiResponse<?> notFound() {
        return create(Status.NOT_FOUND);
    }

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
	public T getLcdata() {
		return lcdata;
	}
	public void setLcdata(T lcdata) {
		this.lcdata = lcdata;
	}

}
