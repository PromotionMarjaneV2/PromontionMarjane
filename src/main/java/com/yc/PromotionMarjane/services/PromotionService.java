package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.Repositories.PromotionRepository;
import com.yc.PromotionMarjane.model.Promotion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository repository;

    public Promotion savePromotion(Promotion promotion) {
        //TODO Add any additional business logic or validation before saving
        return repository.save(promotion);
    }

    public List<Promotion> getAllPromotions() {
        return repository.findAll();
    }

    public Optional<Promotion> getPromotionById(UUID id) {
        return repository.findById(id);
    }

    public Promotion updatePromotion(Promotion promotion) {
        //TODO Add any additional business logic or validation before updating
        return repository.save(promotion);
    }

    public void deletePromotion(UUID id) {
        repository.deleteById(id);
    }
}