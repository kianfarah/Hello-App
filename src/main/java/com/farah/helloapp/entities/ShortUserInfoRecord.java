package com.farah.helloapp.entities;

import java.time.LocalDate;

public record ShortUserInfoRecord(
        Long id,
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        Gender gender
) {
}
