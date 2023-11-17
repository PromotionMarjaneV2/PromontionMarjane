package com.yc.PromotionMarjane.Repositories;

import com.yc.PromotionMarjane.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CentreRepository extends JpaRepository<Centre, UUID> {
}
