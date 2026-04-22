package com.farah.helloapp.entities;

import org.springframework.data.relational.core.mapping.Table;

@Table(name = "address")
public record Address(String userId,
                      String street,
                      String city,
                      String country,
                      String zip) {
}
