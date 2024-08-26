package com.optimagrowth.Spring.boot.dockerized.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "housing_location")
@SequenceGenerator(
        name = "HOUSING_SEQ_GENERATOR",
        sequenceName = "HOUSING_SEQ",
        initialValue = 3647, allocationSize = 1
)
public class HousingLocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOUSING_SEQ_GENERATOR")
    @Column(name = "HL_ID")
    private Long id;
    @Column(name = "HL_NAME")
    private String name;
    @Column(name = "HL_CITY")
    private String city;
    @Column(name = "HL_STATE")
    private String state;
    @Column(name = "HL_PHOTO")
    private String photo;
    @Column(name = "HL_AVAILABLEUNITS")
    private Integer availableUnits;
    @Column(name = "HL_WIFI")
    private Boolean wifi;
    @Column(name = "HL_LAUNDRY")
    private Boolean laundry;
}
