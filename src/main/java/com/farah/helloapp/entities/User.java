package com.farah.helloapp.entities;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "user_info")
@Builder
public record User(@Id Long id,
                   String firstName,
                   String lastName,
                   String email,
                   LocalDate dateOfBirth,
                   Gender gender,
                   @MappedCollection(idColumn = "user_id")
                   Address address,
                   @MappedCollection(idColumn = "user_id")
                   Occupation occupation) {
}