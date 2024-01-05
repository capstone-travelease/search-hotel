package com.capstone.search_hotel.DTOs;

public class ResponseImage {
    private String file_url;
    private Integer hotel_id;

    public ResponseImage() {
    }

    public ResponseImage(String file_url, Integer hotel_id) {
        this.file_url = file_url;
        this.hotel_id = hotel_id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public Integer gethotel_id() {
        return hotel_id;
    }

    public void sethotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "ResponseImage{" +
                "file_url='" + file_url + '\'' +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
