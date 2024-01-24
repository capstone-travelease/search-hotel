package com.capstone.search_hotel.Services;

import com.capstone.search_hotel.DTOs.RequestBodyDTO;
import com.capstone.search_hotel.DTOs.ResponseData;
import com.capstone.search_hotel.DTOs.ResponseImage;
import com.capstone.search_hotel.Entities.ResponseSearch;
import com.capstone.search_hotel.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchHotelServices {
    private final HotelRepository hotelRepository;

    @Autowired
    public SearchHotelServices(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<ResponseData> searchHotel(RequestBodyDTO requestBodyDTO){
        List<ResponseSearch> data = hotelRepository.search(requestBodyDTO.getLocation(), requestBodyDTO.getAdultNumber(), requestBodyDTO.getFromDate(), requestBodyDTO.getToDate());

        Map<Integer, ResponseSearch> minPrices = new LinkedHashMap<>();

        for(ResponseSearch dataSearch : data){
            int hotelId = dataSearch.getHotel_id();
            Double price = dataSearch.getPrice();

            if (!minPrices.containsKey(hotelId) || price < minPrices.get(hotelId).getPrice()){
                minPrices.put(hotelId, dataSearch);
            }
        }

        List<ResponseSearch> minPriceHotels = new ArrayList<>(minPrices.values());


        for(ResponseSearch dataHotel : minPriceHotels ){
            int hotelId = dataHotel.getHotel_id();
            List<ResponseImage> imageList = hotelRepository.listAttachment(hotelId);

            dataHotel.setImages(imageList);
        }

        return List.of(
                new ResponseData(
                        200,
                        minPriceHotels,
                        "Successful"
                )
        );
    }
}
