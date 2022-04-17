package ru.learnUp.feb.learnupjava20.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueService {

    private static final Logger log = LoggerFactory.getLogger(ValueService.class);

    private final String value;

    public ValueService(
            @Value("${service.value}") String value) {
        this.value = value;
    }

    public void print() {
        log.info("{}", value);
    }

}
