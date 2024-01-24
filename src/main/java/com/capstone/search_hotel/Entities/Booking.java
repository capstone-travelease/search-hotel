package com.capstone.search_hotel.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Booking {
    @Id
    private Integer bookingId;
    private Integer userId;
    private Integer hotelId;
    private Integer bookingStatusId;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String taxes;
    private String coupon;
    private String note;
    private Integer totalPrice;
    private LocalDate bookingLocalDate;

    public Booking(Integer bookingId, Integer userId, Integer hotelId, Integer bookingStatusId, LocalDate checkinDate, LocalDate checkoutDate, String taxes, Integer totalPrice, LocalDate bookingLocalDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.bookingStatusId = bookingStatusId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.taxes = taxes;
        this.totalPrice = totalPrice;
        this.bookingLocalDate = bookingLocalDate;
    }

    public Booking(Integer bookingId, Integer userId, Integer hotelId, Integer bookingStatusId, LocalDate checkinDate, LocalDate checkoutDate, String taxes, String coupon, String note, Integer totalPrice, LocalDate bookingLocalDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.bookingStatusId = bookingStatusId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.taxes = taxes;
        this.coupon = coupon;
        this.note = note;
        this.totalPrice = totalPrice;
        this.bookingLocalDate = bookingLocalDate;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getBookingStatusId() {
        return bookingStatusId;
    }

    public void setBookingStatusId(Integer bookingStatusId) {
        this.bookingStatusId = bookingStatusId;
    }

    public LocalDate getcheckinDate() {
        return checkinDate;
    }

    public void setcheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getcheckoutDate() {
        return checkoutDate;
    }

    public void setcheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getBookingLocalDate() {
        return bookingLocalDate;
    }

    public void setBookingLocalDate(LocalDate bookingLocalDate) {
        this.bookingLocalDate = bookingLocalDate;
    }
}
