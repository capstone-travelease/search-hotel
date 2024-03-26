package com.capstone.search_hotel.DTOs;

public class CheckQuantityListDTO {
    private Integer availableRoomQuantity;
    private Integer roomId;
    private Integer hotelId;

    public CheckQuantityListDTO() {
    }

    public CheckQuantityListDTO(Integer availableRoomQuantity, Integer roomId, Integer hotelId) {
        this.availableRoomQuantity = availableRoomQuantity;
        this.roomId = roomId;
        this.hotelId = hotelId;
    }

    public Integer getAvailableRoomQuantity() {
        return availableRoomQuantity;
    }

    public void setAvailableRoomQuantity(Integer availableRoomQuantity) {
        this.availableRoomQuantity = availableRoomQuantity;
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
        return "CheckQuantityListDTO{" +
                "availableRoomQuantity=" + availableRoomQuantity +
                ", roomId=" + roomId +
                ", hotelId=" + hotelId +
                '}';
    }
}
