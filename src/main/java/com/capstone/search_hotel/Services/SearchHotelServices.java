package com.capstone.search_hotel.Services;

import com.capstone.search_hotel.DTOs.RequestBodyDTO;
import com.capstone.search_hotel.DTOs.ResponseData;
import com.capstone.search_hotel.Entities.ResponseSearch;
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


    public List<ResponseData> searchHotel(RequestBodyDTO requestBodyDTO){
        List<ResponseSearch> data = hotelRepository.search(requestBodyDTO.getLocation(), requestBodyDTO.getAdult_number());
        return List.of(
                new ResponseData(
                        200,
                        data,
                        "Successful"
                )
        );
    }
}
