package com.jtj.util;

public class Result<T> {

    private T data;
    private Integer code;
    private String msg;

    /**
     * 若没有数据返回，默认状态码为 0，提示信息为“操作成功！”
     */
    public Result() {
        this.code = CodeStatus.SUCCES;
        this.msg = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为 0，默认提示信息为“操作成功！”
     * @param data
     */
    public Result(T data) {
        this.data = data;
        this.code = CodeStatus.SUCCES;
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为 0，人为指定提示信息
     * @param data
     * @param msg
     */
    public Result(T data, String msg) {
        this.data = data;
        this.code = CodeStatus.SUCCES;
        this.msg = msg;
    }


    public T getData() { return data; }

    public void setData(T data) { this.data = data; }

    public Integer getCode() { return code; }

    public void setCode(Integer code) { this.code = code; }

    public String getMsg() { return msg; }

    public void setMsg(String msg) { this.msg = msg; }
}

