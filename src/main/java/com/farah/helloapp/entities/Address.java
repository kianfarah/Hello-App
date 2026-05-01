package com.farah.helloapp.entities;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "address")
public record Address(
    String userId, String street, @NotBlank String city, String country, String zip) {}
