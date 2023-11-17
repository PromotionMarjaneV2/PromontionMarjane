package com.yc.PromotionMarjane.controller;

import com.yc.PromotionMarjane.model.Promotion;
import com.yc.PromotionMarjane.services.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion savedPromotion = promotionService.savePromotion(promotion);
        return new ResponseEntity<>(savedPromotion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        List<Promotion> promotions = promotionService.getAllPromotions();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable UUID id) {
        Optional<Promotion> promotion = promotionService.getPromotionById(id);
        return promotion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable UUID id, @RequestBody Promotion promotion) {
        if (promotionService.getPromotionById(id).isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        promotion.setId(id);
        Promotion updatedPromotion = promotionService.updatePromotion(promotion);
        return new ResponseEntity<>(updatedPromotion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable UUID id) {
        if (promotionService.getPromotionById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        promotionService.deletePromotion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}