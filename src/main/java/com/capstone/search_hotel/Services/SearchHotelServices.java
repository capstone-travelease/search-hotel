package com.capstone.search_hotel.Services;

import com.capstone.search_hotel.DTOs.ResponseStatus;
import com.capstone.search_hotel.DTOs.SearchResponse;
import com.capstone.search_hotel.Entities.Hotels;
import com.capstone.search_hotel.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHotelServices {
    private final HotelRepository hotelRepository;

    @Autowired
    public SearchHotelServices(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<SearchResponse> SearchHotel(String hotelName){
        List<Hotels> data = hotelRepository.searchHotel(hotelName);

        return List.of(
                new SearchResponse(
                        200,
                        data,
                        "Successful"
                )
        );
    }

    public List<SearchResponse> GetHotel(){
        return List.of(
                new SearchResponse(
                        200,
                        hotelRepository.findAll(),
                        "Successful"
                )
        );
    }
}
