package com.capstone.search_hotel.DTOs;

import java.time.LocalDate;

public class CheckTimeListDTO {
    private Integer bookingStatusId;
    private String bookingStatusName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomQuantity;
    private Integer roomId;
    private Integer hotelId;

    public CheckTimeListDTO() {
    }


    public CheckTimeListDTO(Integer bookingStatusId, String bookingStatusName, LocalDate checkInDate, LocalDate checkOutDate, Integer roomQuantity, Integer roomId, Integer hotelId) {
        this.bookingStatusId = bookingStatusId;
        this.bookingStatusName = bookingStatusName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomQuantity = roomQuantity;
        this.roomId = roomId;
        this.hotelId = hotelId;
    }

    public Integer getBookingStatusId() {
        return bookingStatusId;
    }

    public void setBookingStatusId(Integer bookingStatusId) {
        this.bookingStatusId = bookingStatusId;
    }

    public String getBookingStatusName() {
        return bookingStatusName;
    }

    public void setBookingStatusName(String bookingStatusName) {
        this.bookingStatusName = bookingStatusName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "ResponseCheckTimeList{" +
                "bookingStatusId=" + bookingStatusId +
                ", bookingStatusName=" + bookingStatusName +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", roomQuantity=" + roomQuantity +
                ", roomId=" + roomId +
                ", hotelId=" + hotelId +
                '}';
    }
}
