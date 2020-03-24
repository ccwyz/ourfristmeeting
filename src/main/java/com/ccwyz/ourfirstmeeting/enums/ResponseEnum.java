package com.ccwyz.ourfirstmeeting.enums;

/**
 * @program: ourfirstmeeting
 * @description: 统一异常处理, 抛错归集
 * @author: Charles_Cao
 * @create: 2020-03-22 16:34
 **/
public enum ResponseEnum {
    SUCCESS("000000","处理成功"),
    ERROR("999999","系统异常"),

    BAD_REQUEST("400001","bad request 参数解析失败"),
    METHOD_NOT_ALLOWED("400002", "不支持当前请求方法"),
    INTERNAL_SERVER_ERROR("400003","Internal Server Error 服务异常"),

    DB_INSERT_OR_UPDATE_ERROR("400004","数据库新增或修改异常")

    ;
    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {

        System.out.println();
        ResponseEnum s = ResponseEnum.valueOf("SUCCESS");
        System.out.println( s);
        System.out.println(ResponseEnum.SUCCESS.compareTo(ResponseEnum.ERROR));

        System.out.println(ResponseEnum.SUCCESS.compareTo(null));
    }
}
