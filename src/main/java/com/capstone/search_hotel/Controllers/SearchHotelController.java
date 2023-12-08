package com.capstone.search_hotel.Controllers;

import com.capstone.search_hotel.DTOs.SearchResponse;
import com.capstone.search_hotel.Entities.Hotels;
import com.capstone.search_hotel.Services.SearchHotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/hotel")
public class SearchHotelController {
    private final SearchHotelServices searchHotelServices;

    @Autowired
    public SearchHotelController(SearchHotelServices searchHotelServices) {
        this.searchHotelServices = searchHotelServices;
    }

    @GetMapping("/search/{hotelName}")
    public List<SearchResponse> SearchHotel(@PathVariable("hotelName") String hotelName){
        return searchHotelServices.SearchHotel(hotelName);
    }

    @GetMapping("/get-hotel")
    public List<SearchResponse> GetHotel(){
        return searchHotelServices.GetHotel();
    }
}
