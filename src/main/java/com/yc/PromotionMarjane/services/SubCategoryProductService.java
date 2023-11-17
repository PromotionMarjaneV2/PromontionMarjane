package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.Repositories.SubCategoryProductRepository;
import com.yc.PromotionMarjane.model.SubCategoryProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryProductService {
    private final SubCategoryProductRepository repository;

    public SubCategoryProduct saveSubCategoryProduct(SubCategoryProduct subCategoryProduct) {
        return repository.save(subCategoryProduct);
    }

    public List<SubCategoryProduct> getAllSubCategoryProducts() {
        return repository.findAll();
    }

    public Optional<SubCategoryProduct> getSubCategoryProductById(UUID id) {
        return repository.findById(id);
    }

    public SubCategoryProduct updateSubCategoryProduct(SubCategoryProduct subCategoryProduct) {
        return repository.save(subCategoryProduct);
    }

    public void deleteSubCategoryProduct(UUID id) {
        repository.deleteById(id);
    }
}