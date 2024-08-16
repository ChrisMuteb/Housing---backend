package com.optimagrowth.Spring.boot.dockerized.repository;

import com.optimagrowth.Spring.boot.dockerized.entity.HousingLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingLocationRepository extends JpaRepository<HousingLocation, Long> {
}
