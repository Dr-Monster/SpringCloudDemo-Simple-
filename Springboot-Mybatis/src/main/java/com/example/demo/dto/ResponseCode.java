package com.example.demo.dto;

/**
 * Created by DELL on 2017/8/4.
 * @author yangle
 */
public enum ResponseCode {


    SUCCESS(100000,"处理成功!",true),
    ERROR_PARAMTER(200010,"参数错误!"),
    SYSTEM_ERROR(100001,"系统内部错误！"),
    SELECT_PARAM_NOT_ENOUGH(100003,"查询参数不足！"),
    SELECT_NULL_RESULT(100005,"没有要同步详情的查询结果！",true),
    GET_TOKEN_FAIL(100007,"调用化塑汇获取Token失败"),
    CHANNEL_SUCCESS(100000,"处理成功!",true),
    SYN_DATA_FAILURE(220017,"调用化塑汇同步数据失败")




    ;
    private Integer code;
    private String msg;
    private boolean success;

    private ResponseCode(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = false;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return code + "-" + msg;
    }
}
