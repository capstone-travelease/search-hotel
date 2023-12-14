package com.capstone.search_hotel.Repositories;

import com.capstone.search_hotel.Entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capstone.search_hotel.Entities.ResponseSearch;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
//    new com.capstone.search_hotel.Entities.ResponseSearch(h.hotel_id ,h.hotel_name, h.hotel_city, h.star_rating, atc.file_url, r.room_price)
    @Query("SELECT new com.capstone.search_hotel.Entities.ResponseSearch(h.hotel_id ,h.hotel_name, h.hotel_city, h.star_rating, atc.file_url, r.room_price)\n" +
            "FROM Hotels h\n" +
            "INNER JOIN Rooms r ON h.hotel_id = r.hotel_id\n" +
            "INNER JOIN Roomdetail rd ON rd.room_id = r.room_id\n" +
            "INNER JOIN Hotel_attachment hat ON hat.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment atc ON atc.attachment_id = hat.attachment_id\n" +
            "WHERE h.hotel_city LIKE %?1% AND rd.room_capacity <= ?2"
    )
    List<ResponseSearch> search(String city, Integer capacity);
}
