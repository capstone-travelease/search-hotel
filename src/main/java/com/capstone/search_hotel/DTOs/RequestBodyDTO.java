package com.capstone.search_hotel.DTOs;

import java.time.LocalDate;
import java.util.List;

public class RequestBodyDTO {
    private String location;
    private LocalDate from_date;
    private LocalDate to_date;
    private Integer adult_number;
    private Integer roomNumber;
    private String hotelName;
    private Integer money_from;
    private Integer money_to;
    private List<String> facilities;
    private Boolean price_low_to_high;
    private Boolean price_high_to_low;

    public RequestBodyDTO() {
    }

    public RequestBodyDTO(String location, LocalDate from_date, LocalDate to_date, Integer adult_number, Integer roomNumber) {
        this.location = location;
        this.from_date = from_date;
        this.to_date = to_date;
        this.adult_number = adult_number;
        this.roomNumber = roomNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public Integer getAdult_number() {
        return adult_number;
    }

    public void setAdult_number(Integer adult_number) {
        this.adult_number = adult_number;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
