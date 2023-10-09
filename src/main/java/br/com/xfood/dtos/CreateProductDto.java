package br.com.xfood.dtos;

import java.math.BigDecimal;

public record CreateProductDto(String name, String description, BigDecimal price) {}
