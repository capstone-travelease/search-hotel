package com.capstone.search_hotel.Controllers;

import com.capstone.search_hotel.DTOs.RequestBodyDTO;
import com.capstone.search_hotel.DTOs.ResponseData;
import com.capstone.search_hotel.Entities.ResponseSearch;
import com.capstone.search_hotel.Services.SearchHotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/hotel")
public class SearchHotelController {
    private final SearchHotelServices searchHotelServices;

    @Autowired
    public SearchHotelController(SearchHotelServices searchHotelServices) {
        this.searchHotelServices = searchHotelServices;
    }

    @PostMapping("/search")
    public ResponseData SearchPost(@RequestBody RequestBodyDTO requestBodyDTO){
        return searchHotelServices.searchHotel(requestBodyDTO).get(0);
    }
}
