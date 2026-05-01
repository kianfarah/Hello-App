package com.farah.helloapp.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class OnWeekendCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        DayOfWeek today =  LocalDate.now().getDayOfWeek();
        return today == DayOfWeek.FRIDAY || today == DayOfWeek.SUNDAY;
    }
}
