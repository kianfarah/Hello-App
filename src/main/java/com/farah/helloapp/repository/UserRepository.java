package com.farah.helloapp.repository;

import com.farah.helloapp.entities.User;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {

  Optional<User> findByFirstName(String email);
}
