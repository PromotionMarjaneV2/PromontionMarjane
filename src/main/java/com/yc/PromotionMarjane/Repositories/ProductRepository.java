package com.yc.PromotionMarjane.Repositories;

import com.yc.PromotionMarjane.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
