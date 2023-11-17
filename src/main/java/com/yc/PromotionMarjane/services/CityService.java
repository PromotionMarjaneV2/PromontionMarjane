package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.Repositories.CityRepository;
import com.yc.PromotionMarjane.model.City;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public City saveCity(City city) {
        log.info("Saving city: {}", city);
        return repository.save(city);
    }

    public List<City> getAllCities() {
        log.info("Fetching all cities");
        return repository.findAll();
    }

    public Optional<City> getCityById(UUID cityId) {
        log.info("Fetching city by ID: {}", cityId);
        return repository.findById(cityId);
    }

    public City updateCity(City city) {
        log.info("Updating city: {}", city);
        return repository.save(city);
    }

    public void deleteCity(UUID cityId) {
        log.info("Deleting city by ID: {}", cityId);
        repository.deleteById(cityId);
    }
}
