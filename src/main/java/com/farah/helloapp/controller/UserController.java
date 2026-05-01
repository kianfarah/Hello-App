package com.farah.helloapp.controller;

import com.farah.helloapp.entities.User;
import com.farah.helloapp.repository.UserRepository;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository repository;
  private final Logger log = LoggerFactory.getLogger(UserController.class);

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    log.info("getAllUsers");
    return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable final Long id) {
    log.info("request user with id {}", id);
    return repository
        .findById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new UserNotFoundException("user with id " + id + " not found"));
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody @Valid final User user) {
    log.info("starting saving user {}", user);
    return new ResponseEntity<>(repository.save(user), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> deleteUserById(@PathVariable final Long id) {
    repository.deleteById(id);
    log.info("deleted user with id {}", id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(path = "/user")
  public ResponseEntity<User> findByFirstName(@RequestParam @Valid final String firstName) {
    log.info("request user with name {}", firstName);
    return repository.findByFirstName(firstName).map(ResponseEntity::ok).orElseThrow();
    // .orElseThrow(() -> new UserNotFoundException("user with name " + firstName + " not found"));
  }
}
