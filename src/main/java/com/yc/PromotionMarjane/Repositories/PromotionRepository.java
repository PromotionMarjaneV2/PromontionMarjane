package com.yc.PromotionMarjane.Repositories;

import com.yc.PromotionMarjane.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PromotionRepository extends JpaRepository<Promotion, UUID> {
}
