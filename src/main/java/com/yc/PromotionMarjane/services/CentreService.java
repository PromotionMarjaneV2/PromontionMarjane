package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.Repositories.CentreRepository;
import com.yc.PromotionMarjane.model.Centre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CentreService {
    private final CentreRepository repository;

    public Centre saveCentre(Centre centre) {
        return repository.save(centre);
    }

    public List<Centre> getAllCentres() {
        return repository.findAll();
    }

    public Optional<Centre> getCentreById(UUID id) {
        return repository.findById(id);
    }

    public Centre updateCentre(Centre centre) {
        return repository.save(centre);
    }

    public void deleteCentre(UUID id) {
        repository.deleteById(id);
    }
}