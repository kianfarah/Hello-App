package com.farah.helloapp.entities;

import lombok.Builder;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "occupation")
@Builder
public record Occupation(String userId, String jobTitle, String company) {
}
