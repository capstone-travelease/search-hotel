package com.capstone.search_hotel.Services;

import com.capstone.search_hotel.DTOs.RequestBodyDTO;
import com.capstone.search_hotel.DTOs.ResponseData;
import com.capstone.search_hotel.Entities.ResponseSearch;
import com.capstone.search_hotel.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchHotelServices {
    private final HotelRepository hotelRepository;

    @Autowired
    public SearchHotelServices(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<ResponseData> searchHotel(RequestBodyDTO requestBodyDTO){
        List<ResponseSearch> data = hotelRepository.search(requestBodyDTO.getLocation());

        Map<Integer, ResponseSearch> minPrices = new HashMap<>();

        for(ResponseSearch dataSearch : data){
            int hotelId = dataSearch.getHotel_id();
            Double price = dataSearch.getPrice();

            if (!minPrices.containsKey(hotelId) || price < minPrices.get(hotelId).getPrice()){
                minPrices.put(hotelId, dataSearch);
            }
        }

        List<ResponseSearch> minPriceHotels = new ArrayList<>(minPrices.values());

        return List.of(
                new ResponseData(
                        200,
                        minPriceHotels,
                        "Successful"
                )
        );
    }
}
