package com.yc.PromotionMarjane.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //TODO Add other sub-category-specific fields

}
