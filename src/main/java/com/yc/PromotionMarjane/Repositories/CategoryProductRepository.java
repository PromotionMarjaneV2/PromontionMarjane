package com.yc.PromotionMarjane.Repositories;

import com.yc.PromotionMarjane.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, UUID> {
}
