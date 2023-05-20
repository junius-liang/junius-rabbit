package com.rabbit.model;

import java.util.List;

/**
 * @author junius
 * @date 2023/05/20 13:55
 * @project junius-rabbit
 **/
public class APIModel<T> {
    /**
     * 业务状态码，1成功, 其他失败
     */
    private String code;
    /**
     * 响应消息
     */
    private String msg;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    /**
     * 响应结果
     */
    private List<T> result;


}

