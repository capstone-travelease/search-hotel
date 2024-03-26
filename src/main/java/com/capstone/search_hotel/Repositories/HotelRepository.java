package com.capstone.search_hotel.Repositories;

import com.capstone.search_hotel.DTOs.CheckTimeListDTO;
import com.capstone.search_hotel.DTOs.ResponseImage;
import com.capstone.search_hotel.DTOs.QuantityListDTO;
import com.capstone.search_hotel.Entities.Hotels;
import com.capstone.search_hotel.Entities.ResponseSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
    @Query("SELECT new com.capstone.search_hotel.Entities.ResponseSearch(h.hotel_id ,h.hotel_name, h.hotel_city, h.star_rating, r.room_price)\n" +
            "FROM Hotels h\n" +
            "INNER JOIN Rooms r ON h.hotel_id = r.hotel_id\n" +
            "INNER JOIN Roomdetail rd ON rd.room_id = r.room_id\n" +
            "INNER JOIN Hotel_attachment hat ON hat.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment atc ON atc.attachment_id = hat.attachment_id\n" +
            "WHERE h.hotel_city LIKE %?1% AND rd.room_capacity >= ?2 AND r.room_quantity >= ?3\n"+
            "ORDER BY r.room_price"
    )
    List<ResponseSearch> search(String city, Integer capacity, Integer quantity);

    @Query("SELECT new com.capstone.search_hotel.DTOs.ResponseImage(atc.file_url, h.hotel_id) FROM Attachment atc\n" +
            "INNER JOIN Hotel_attachment hatc ON hatc.attachment_id = atc.attachment_id\n" +
            "INNER JOIN Hotels h ON h.hotel_id = hatc.hotel_id\n" +
            "WHERE h.hotel_id = ?1")
    List<ResponseImage> listAttachment(Integer hotelId);

    @Query("SELECT new com.capstone.search_hotel.DTOs.CheckTimeListDTO(b.bookingStatusId, bs.bookingStatusName, b.checkinDate, b.checkoutDate, pl.room_quantity, pl.room_id, r.hotel_id) FROM Booking b\n" +
            "INNER JOIN ProductList pl ON pl.booking_id = b.bookingId\n" +
            "INNER JOIN Rooms r ON r.room_id = pl.room_id\n" +
            "INNER JOIN BookingStatus bs ON bs.bookingStatusId = b.bookingStatusId\n" +
            "WHERE b.checkinDate >= ?1 AND b.checkoutDate <= ?2\n" +
            "ORDER BY b.bookingStatusId\n")
    List<CheckTimeListDTO> checkTime(LocalDate checkIn, LocalDate checkOut);

    @Query("SELECT new com.capstone.search_hotel.DTOs.QuantityListDTO(room_id, room_quantity) FROM Rooms r\n" +
            "WHERE room_id = ?1")
    List<QuantityListDTO> getStaticQuantity(Integer roomId);

    @Query("SELECT r.room_quantity FROM Rooms r INNER JOIN Hotels h ON h.hotel_id = r.hotel_id WHERE h.hotel_id = ?1")
    List<Integer> listRoomQuantityByHotel(Integer hotelId);
}
