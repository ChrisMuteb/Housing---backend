package com.optimagrowth.Spring.boot.dockerized.dto;

import jakarta.persistence.Column;

public record HousingLocationRequest(
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
