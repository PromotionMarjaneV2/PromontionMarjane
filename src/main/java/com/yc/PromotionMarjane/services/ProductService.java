package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.model.Product;
import com.yc.PromotionMarjane.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(UUID id) {
        return repository.findById(id);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }
}