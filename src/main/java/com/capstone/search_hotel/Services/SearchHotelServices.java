package com.capstone.search_hotel.Services;

import com.capstone.search_hotel.DTOs.*;
import com.capstone.search_hotel.Entities.ResponseSearch;
import com.capstone.search_hotel.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchHotelServices {
    private final HotelRepository hotelRepository;

    @Autowired
    public SearchHotelServices(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<ResponseData> searchHotel(RequestBodyDTO requestBodyDTO){
        // List all rooms quantity that already booked
        List<CheckQuantityListDTO> listQuantityBooked = checkQuantityByDate(requestBodyDTO.getFromDate(), requestBodyDTO.getToDate());

        // Sum all quantity that already booked have the same hotelId
        Map<Integer, Integer> mapSumQuantityHotel = sumQuantity(listQuantityBooked);

        // List search data that suitable with requestBody input
        List<ResponseSearch> data = hotelRepository.search(requestBodyDTO.getLocation(), requestBodyDTO.getAdultNumber(), requestBodyDTO.getRoomNumber());

        // Variable use for select just only minPrice in each hotel with hotelId
        Map<Integer, ResponseSearch> minPrices = new LinkedHashMap<>();

        for(ResponseSearch dataSearch : data){
            int hotelId = dataSearch.getHotel_id();
            Double price = dataSearch.getPrice();

            if (!minPrices.containsKey(hotelId) || price < minPrices.get(hotelId).getPrice()){
                minPrices.put(hotelId, dataSearch);
            }
        }

        // Variable use for add minPrice hotel before and add imageList to this variable
        List<ResponseSearch> minPriceHotels = new ArrayList<>(minPrices.values());

        for(ResponseSearch dataHotel : minPriceHotels ){
            int hotelId = dataHotel.getHotel_id();
            List<ResponseImage> imageList = hotelRepository.listAttachment(hotelId);

            dataHotel.setImages(imageList);
        }

        /* This for loop is using to check all quantity room in 1 hotel is full or not.
         If it is, that hotel will be removed from list */
        for(var i = 0 ; i < minPriceHotels.size(); i++){
            Integer hotelId = minPriceHotels.get(i).getHotel_id();
            Integer totalRoomInHotel = sumNumberInList(hotelRepository.listRoomQuantityByHotel(hotelId));

            if(mapSumQuantityHotel.containsKey(hotelId)){
                if(mapSumQuantityHotel.get(hotelId) - totalRoomInHotel == 0){
                    minPriceHotels.remove(i);
                }
            }
        }

        return List.of(
                new ResponseData(
                        200,
                        minPriceHotels,
                        "Successful"
                )
        );
    }

    private static Map<Integer, Integer> sumQuantity(List<CheckQuantityListDTO> listQuantityChecked) {
        Map<Integer, Integer> mapSumQuantityHotel = new LinkedHashMap<>();
        int sum = 0;

        // Loop for sum all quantity with the same hotelId
        for(var i = 0; i < listQuantityChecked.size(); i++){
            Integer hotelId = listQuantityChecked.get(i).getHotelId();
            Integer roomQuantity = listQuantityChecked.get(i).getAvailableRoomQuantity();

            if(!mapSumQuantityHotel.containsKey(hotelId)){
                mapSumQuantityHotel.put(hotelId, roomQuantity);
                sum = roomQuantity;
            }
            else{
                sum = sum + roomQuantity;
                mapSumQuantityHotel.put(hotelId, sum);
            }
        }
        return mapSumQuantityHotel;
    }

    public List<CheckQuantityListDTO> checkQuantityByDate(LocalDate checkIn, LocalDate checkOut){
        // List search data that suitable with check in and check out date input
        List<CheckTimeListDTO> checkTimeLists = hotelRepository.checkTime(checkIn, checkOut);

        Map<Integer, List<CheckTimeListDTO>> groupCheckTime = checkTimeLists.stream()
                .collect(Collectors.groupingBy(CheckTimeListDTO::getRoomId));

        // This variable for list every rooms in ticket that have a status Cancelled and remove it
        Map<Integer, List<CheckTimeListDTO>> removedCancelList = new LinkedHashMap<>();

        // This list is using for counting room quantity in n hotel
        List<CheckQuantityListDTO> countQuantity = new LinkedList<>();

        groupCheckTime.forEach((index,responseList) -> {
            List<CheckTimeListDTO> arrTemp = new ArrayList<>();

            for(var j = 0; j < responseList.size(); j++){
                if(responseList.get(j).getBookingStatusId() != 3){ // Cancelled status is 3 so remove it.
                    arrTemp.add(responseList.get(j));
                    removedCancelList.put(index,arrTemp);
                }
            }
        });

        removedCancelList.forEach((roomId, data) -> {
            Integer counter = 0;
            Integer hotelId = 0;

            for(var i = 0; i < data.size(); i++){
                counter = counter + data.get(i).getRoomQuantity();
                hotelId = data.get(i).getHotelId();
            }
            counter = staticQuantityList(roomId) - counter;
            countQuantity.add(
                    new CheckQuantityListDTO(
                            counter,
                            roomId,
                            hotelId
                    )
            );
        });

        return  countQuantity;
    }

    public Integer staticQuantityList(Integer roomId){
        var result = 0;
        // List all room quantity in Rooms Table with roomId to specify room
        List<QuantityListDTO> staticQuantityList = hotelRepository.getStaticQuantity(roomId);
        for(var i = 0; i < staticQuantityList.size(); i++){
            result = staticQuantityList.get(i).getRoomQuantity();
        }
        return result; // Add this line to return the result
    }

    public Integer sumNumberInList(List<Integer> listNum){
        Integer result = 0;
        for(var i = 0; i < listNum.size(); i++){
            result = result + listNum.get(i);
        }
        return result;
    }
}
