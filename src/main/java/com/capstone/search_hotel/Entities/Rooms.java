package com.capstone.search_hotel.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Rooms {
    @Id
    private Integer room_id;
    private String room_name;
    private String room_images;
    private Integer room_status;
    private Double room_price;
    private Integer room_type_id;
    private Integer room_quantity;
    private Integer hotel_id;

    public Rooms() {
    }

    public Rooms(Integer room_id, String room_name, String room_images, Integer room_status, Double room_price, Integer room_type_id, Integer room_quantity, Integer hotel_id) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_images = room_images;
        this.room_status = room_status;
        this.room_price = room_price;
        this.room_type_id = room_type_id;
        this.room_quantity = room_quantity;
        this.hotel_id = hotel_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_images() {
        return room_images;
    }

    public void setRoom_images(String room_images) {
        this.room_images = room_images;
    }

    public Integer getRoom_status() {
        return room_status;
    }

    public void setRoom_status(Integer room_status) {
        this.room_status = room_status;
    }

    public Double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Double room_price) {
        this.room_price = room_price;
    }

    public Integer getRoom_quantity() {
        return room_quantity;
    }

    public void setRoom_quantity(Integer room_quantity) {
        this.room_quantity = room_quantity;
    }

    public Integer getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(Integer room_type_id) {
        this.room_type_id = room_type_id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "room_id=" + room_id +
                ", room_name='" + room_name + '\'' +
                ", room_images='" + room_images + '\'' +
                ", room_status=" + room_status +
                ", room_price=" + room_price +
                ", room_type_id=" + room_type_id +
                ", room_quantity=" + room_quantity +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
