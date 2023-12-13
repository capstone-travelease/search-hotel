package com.capstone.search_hotel.DTOs;

import com.capstone.search_hotel.Entities.ResponseSearch;

import java.util.List;

public class ResponseData {
    private Integer code;
    private List<ResponseSearch> data;
    private String message;

    public ResponseData() {
    }

    public ResponseData(Integer code, List<ResponseSearch> data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<ResponseSearch> getData() {
        return data;
    }

    public void setData(List<ResponseSearch> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
