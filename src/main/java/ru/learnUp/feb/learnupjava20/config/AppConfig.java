package ru.learnUp.feb.learnupjava20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import ru.learnUp.feb.learnupjava20.service.Operation;
import ru.learnUp.feb.learnupjava20.service.Processor;
import ru.learnUp.feb.learnupjava20.service.registry.ProcessorRegistry;

import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public ProcessorRegistry processorRegistry(
            Processor sumProcessor,
            Processor subtractProcessor,
            Processor multiplyProcessor
    ) {
        return new ProcessorRegistry(
                Map.of(
                        Operation.PLUS, sumProcessor,
                        Operation.MINUS, subtractProcessor,
                        Operation.MULTIPLY, multiplyProcessor
                ));
    }

}
