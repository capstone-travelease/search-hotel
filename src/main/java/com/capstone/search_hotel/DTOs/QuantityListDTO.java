package com.capstone.search_hotel.DTOs;

public class QuantityListDTO {
    private Integer roomId;
    private Integer roomQuantity;

    public QuantityListDTO() {
    }

    public QuantityListDTO(Integer roomId, Integer roomQuantity) {
        this.roomId = roomId;
        this.roomQuantity = roomQuantity;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    @Override
    public String toString() {
        return "ResponseQuantityDTO{" +
                "roomId=" + roomId +
                ", roomQuantity=" + roomQuantity +
                '}';
    }
}
