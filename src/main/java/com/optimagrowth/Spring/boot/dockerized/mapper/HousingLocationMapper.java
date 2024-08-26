package com.optimagrowth.Spring.boot.dockerized.mapper;

import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationRequest;
import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationResponse;
import com.optimagrowth.Spring.boot.dockerized.entity.HousingLocation;
import org.springframework.stereotype.Service;

@Service
public class HousingLocationMapper {
    public HousingLocation toHouseLocation(HousingLocationRequest housingLocationRequest){
        if(housingLocationRequest == null){
            return null;
        }

        return HousingLocation.builder()
                .id(housingLocationRequest.id())
                .name(housingLocationRequest.name())
                .city(housingLocationRequest.city())
                .state(housingLocationRequest.state())
                .photo(housingLocationRequest.photo())
                .availableUnits(housingLocationRequest.availableUnits())
                .wifi(housingLocationRequest.wifi())
                .laundry(housingLocationRequest.laundry())
                .build();
    }

    public HousingLocationResponse fromHousingLocation(HousingLocation housingLocation){

        return new HousingLocationResponse(
                housingLocation.getId(),
                housingLocation.getName(),
                housingLocation.getCity(),
                housingLocation.getState(),
                housingLocation.getPhoto(),
                housingLocation.getAvailableUnits(),
                housingLocation.getWifi(),
                housingLocation.getLaundry()
        );
    }
}
