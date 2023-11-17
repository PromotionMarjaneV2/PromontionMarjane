package com.yc.PromotionMarjane.services;

import com.yc.PromotionMarjane.Repositories.UserRepository;
import com.yc.PromotionMarjane.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public void registerUser(User user) {
        addUser(user);
    }

    public Optional<User> getUser(String key) {
        return repository.findByPersonalInfoPhoneNumberOrPersonalInfoEmail(key, key);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMINISTRATOR')")
    public void registerAdmin(User user) {
        addUser(user);
    }

    private void addUser(User user) {
        var matches = thisNaturalIdExists(user);
        if (!matches.isEmpty())
            throw new ResourceNotCreatedException(matches);

        User person = null;

        try {
            person = repository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        assert person != null;
        if (person.getUserId() == null)
            throw new ResourceNotCreatedException("Could not create this user");
    }

    private Map<String, String> thisNaturalIdExists(User user) {
        Map<String, String> matches = new HashMap<>();

        try {
            var phoneNumberMatch = repository.findByPersonalInfoPhoneNumber(user.getPersonalInfo().getPhoneNumber());
            if (phoneNumberMatch.isPresent())
                matches.put("phoneNumber", "User with this phone number already exists");
        } catch (Exception ignored) {
        }

        try {
            var emailMatch = repository.findByPersonalInfoEmail(user.getPersonalInfo().getEmail());
            if (emailMatch.isPresent())
                matches.put("email", "User with this email already exists");
        } catch (Exception ignored) {
        }

        return matches;
    }

    public User getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotCreatedException("Could not find this user"));
    }
}