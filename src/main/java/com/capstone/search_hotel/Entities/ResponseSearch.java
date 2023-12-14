package com.capstone.search_hotel.Entities;

public class ResponseSearch {
    private Integer hotel_id;
    private String hotel_name;
    private String hotel_city;
    private Double star_rating;
    private String images;
    private Double price;

    public ResponseSearch() {
    }

    public ResponseSearch(Integer hotel_id, String hotel_name, String hotel_city, Double star_rating, String images, Double price) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.star_rating = star_rating;
        this.images = images;
        this.price = price;
    }

    public ResponseSearch(Integer hotel_id, Double price) {
        this.hotel_id = hotel_id;
        this.price = price;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public Double getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Double star_rating) {
        this.star_rating = star_rating;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ResponseSearch{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_city='" + hotel_city + '\'' +
                ", star_rating=" + star_rating +
                ", images='" + images + '\'' +
                ", price=" + price +
                '}';
    }
}
