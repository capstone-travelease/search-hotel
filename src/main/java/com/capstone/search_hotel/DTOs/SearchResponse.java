package com.capstone.search_hotel.DTOs;

import com.capstone.search_hotel.Entities.Hotels;

import java.util.List;

public class SearchResponse {
    private Integer code;
    private List<Hotels> data;
    private String message;

    public SearchResponse() {
    }

    public SearchResponse(Integer code, List<Hotels> data, String message) {
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

    public List<Hotels> getData() {
        return data;
    }

    public void setData(List<Hotels> data) {
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
