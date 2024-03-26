package com.capstone.search_hotel.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ProductList {
    @Id
    private Integer room_id;
    private Integer booking_id;
    private Integer room_quantity;

    public ProductList() {
    }

    public ProductList(Integer room_id, Integer booking_id, Integer room_quantity) {
        this.room_id = room_id;
        this.booking_id = booking_id;
        this.room_quantity = room_quantity;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Integer booking_id) {
        this.booking_id = booking_id;
    }

    public Integer getRoom_quantity() {
        return room_quantity;
    }

    public void setRoom_quantity(Integer room_quantity) {
        this.room_quantity = room_quantity;
    }
}
