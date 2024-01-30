package com.capstone.search_hotel.Repositories;

import com.capstone.search_hotel.DTOs.ResponseImage;
import com.capstone.search_hotel.Entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capstone.search_hotel.Entities.ResponseSearch;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
//    new com.capstone.search_hotel.Entities.ResponseSearch(h.hotel_id ,h.hotel_name, h.hotel_city, h.star_rating, atc.file_url, r.room_price)
    @Query("SELECT new com.capstone.search_hotel.Entities.ResponseSearch(h.hotel_id ,h.hotel_name, h.hotel_city, h.star_rating, r.room_price)\n" +
            "FROM Hotels h\n" +
            "INNER JOIN Rooms r ON h.hotel_id = r.hotel_id\n" +
            "INNER JOIN Roomdetail rd ON rd.room_id = r.room_id\n" +
            "INNER JOIN Hotel_attachment hat ON hat.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment atc ON atc.attachment_id = hat.attachment_id\n" +
            "INNER JOIN Booking bk ON bk.hotelId = h.hotel_id\n" +
            "INNER JOIN BookingStatus bks ON bks.bookingStatusId = bk.bookingStatusId\n" +
            "WHERE h.hotel_city LIKE %?1% AND rd.room_capacity >= ?2\n"+
            "ORDER BY r.room_price"
    )
    List<ResponseSearch> search(String city, Integer capacity, LocalDate checkIn, LocalDate checkOut);

    @Query("SELECT new com.capstone.search_hotel.DTOs.ResponseImage(atc.file_url, h.hotel_id) FROM Attachment atc\n" +
            "INNER JOIN Hotel_attachment hatc ON hatc.attachment_id = atc.attachment_id\n" +
            "INNER JOIN Hotels h ON h.hotel_id = hatc.hotel_id\n" +
            "WHERE h.hotel_id = ?1")
    List<ResponseImage> listAttachment(Integer hotelId);
}
