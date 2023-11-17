package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.Repositories.CategoryProductRepository;
import com.yc.PromotionMarjane.model.CategoryProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryProductService {
    private final CategoryProductRepository repository;

    public CategoryProduct saveCategoryProduct(CategoryProduct categoryProduct) {
        log.debug("Request to save CategoryProduct : {}", categoryProduct);
        return repository.save(categoryProduct);
    }

    public List<CategoryProduct> getAllCategoryProducts() {
        log.debug("Request to get all CategoryProducts");
        return repository.findAll();
    }

    public Optional<CategoryProduct> getCategoryProductById(UUID id) {
        log.debug("Request to get CategoryProduct : {}", id);
        return repository.findById(id);
    }

    public CategoryProduct updateCategoryProduct(CategoryProduct categoryProduct) {
        log.debug("Request to update CategoryProduct : {}", categoryProduct);
        return repository.save(categoryProduct);
    }

    public void deleteCategoryProduct(UUID id) {
        log.debug("Request to delete CategoryProduct : {}", id);
        repository.deleteById(id);
    }
}
