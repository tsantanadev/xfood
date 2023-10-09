package br.com.xfood.models;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

public record ProductModel(
        @MongoId
        String id,
        String name,
        String description,
        BigDecimal price) {
}
