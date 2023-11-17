package com.yc.PromotionMarjane.Repositories;

import com.yc.PromotionMarjane.model.SubCategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubCategoryProductRepository extends JpaRepository<SubCategoryProduct, UUID> {
}