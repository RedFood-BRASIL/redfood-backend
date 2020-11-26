package com.github.vicenthy.endpoints.dto;

import java.util.List;

public class BaseResponse<T> {

    private T data;
    private String msg;
    private List<String> erros;

    public BaseResponse(T data, List<String> erros) {
        this.setData(data);
        this.setErros(erros);
    }


    public BaseResponse(T data, String msg) {
        this.setData(data);
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResponse(T data) {
        this.setData(data);
    }

}
