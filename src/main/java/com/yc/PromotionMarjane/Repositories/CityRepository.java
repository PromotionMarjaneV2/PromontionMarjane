package com.yc.PromotionMarjane.Repositories;

import com.yc.PromotionMarjane.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}