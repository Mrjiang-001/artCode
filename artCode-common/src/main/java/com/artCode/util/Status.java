package com.artCode.util;

/**
 * 功能描述: 统一 Response 状态码
 * @author mhqf
 */
public enum Status {

	SUCCESS(0, "操作成功。"),
	SAVESUCCESS(0, "保存成功。"),
	UPDATESUCCESS(0, "修改成功。"),
	NOT_VALID_PARAM(400, "提交的参数有误，数据加载失败。"),
    NOT_LOGIN(401, "用户尚未登录。"),
    FORBIDDEN(403, "权限不足，拒绝访问。"),
    NOT_FOUND(404, "请求的资源不存在或者已经被删除。"),
    METHOD_NOT_ALLOWED(405, "HTTP请求方法不支持。"),
    INTERNAL_SERVER_ERROR(500, "发生未知错误，请求失败。");

    private int code;

    private String msg;

    Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
