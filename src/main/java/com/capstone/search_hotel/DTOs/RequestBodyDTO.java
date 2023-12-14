package com.capstone.search_hotel.DTOs;

import java.time.LocalDate;
import java.util.List;

public class RequestBodyDTO {
    private String location;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer adultNumber;
    private Integer roomNumber;
    private String hotelName;
    private Integer money_from;
    private Integer money_to;
    private List<String> facilities;
    private Boolean price_low_to_high;
    private Boolean price_high_to_low;

    public RequestBodyDTO() {
    }

    public RequestBodyDTO(String location, LocalDate fromDate, LocalDate toDate, Integer adultNumber, Integer roomNumber) {
        this.location = location;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.adultNumber = adultNumber;
        this.roomNumber = roomNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(Integer adultNumber) {
        this.adultNumber = adultNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
