package com.farah.helloapp;

import com.farah.helloapp.entities.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
