package com.capstone.search_hotel.Repositories;

import com.capstone.search_hotel.Entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
    @Query("SELECT h FROM Hotels h WHERE h.hotel_name LIKE %?1%")
    List<Hotels> searchHotel(String name);
}
