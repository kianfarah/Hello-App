package com.farah.helloapp.entities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GreetingServiceImpl {

  public String weekendGreeting() {
    log.info("Here this thing got called");
    return "Happy Friday - soon it will be Monday :-)";
  }
}
