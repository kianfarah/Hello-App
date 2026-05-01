package com.farah.helloapp.config;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnWeekendCondition implements Condition {
  @Override
  public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
    final DayOfWeek today = LocalDate.now().getDayOfWeek();
    return today == DayOfWeek.FRIDAY || today == DayOfWeek.SUNDAY;
  }
}
