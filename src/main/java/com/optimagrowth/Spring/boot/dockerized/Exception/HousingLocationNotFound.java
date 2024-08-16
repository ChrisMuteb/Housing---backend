package com.optimagrowth.Spring.boot.dockerized.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HousingLocationNotFound extends RuntimeException{
    private final String msg;
}
