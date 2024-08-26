package com.optimagrowth.Spring.boot.dockerized.dto;

public record HousingLocationResponse(
        Long id,
        String name,
        String city,
        String state,
        String photo,
        Integer availableUnits,
        Boolean wifi,
        Boolean laundry
) {
}
