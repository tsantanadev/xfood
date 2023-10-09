package br.com.xfood.dtos;

import java.math.BigDecimal;

public record ProductDto(String id, String name, String description, BigDecimal price) {}
