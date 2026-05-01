package com.farah.helloapp.config;

import com.farah.helloapp.entities.GreetingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfig {

  @Bean
  @Conditional(OnWeekendCondition.class)
  public GreetingServiceImpl greetingService() {
    log.info("************i was here**********");
    return new GreetingServiceImpl();
  }
}
