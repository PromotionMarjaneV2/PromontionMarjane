package com.yc.PromotionMarjane.controller;
import com.yc.PromotionMarjane.Repositories.UserRepository;
import com.yc.PromotionMarjane.exceptions.ResourceNotFoundException;
import com.yc.PromotionMarjane.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found bor this id " + userId));
        return ResponseEntity.ok(user);
    }
}
