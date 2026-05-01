package com.farah.helloapp.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "user_info")
@Builder
public record User(
    @Id Long id,
    @NotBlank(message = "Name is required") String firstName,
    String lastName,
    String email,
    LocalDate dateOfBirth,
    Gender gender,
    @MappedCollection(idColumn = "user_id") @Valid Address address,
    @MappedCollection(idColumn = "user_id") Occupation occupation) {}
