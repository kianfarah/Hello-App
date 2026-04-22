package com.farah.helloapp.entities;

import org.springframework.data.relational.core.mapping.Table;

@Table(name = "occupation")
public record Occupation(String userId, String jobTitle, String company) {
}
