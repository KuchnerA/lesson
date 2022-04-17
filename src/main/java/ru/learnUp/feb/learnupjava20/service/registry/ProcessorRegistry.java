package ru.learnUp.feb.learnupjava20.service.registry;

import ru.learnUp.feb.learnupjava20.service.Operation;
import ru.learnUp.feb.learnupjava20.service.Processor;

import java.util.Map;

public class ProcessorRegistry {

    private final Map<Operation, Processor> registry;


    public ProcessorRegistry(Map<Operation, Processor> registry) {
        this.registry = registry;
    }

    public Processor findByType(Operation operation) {
        if(!registry.containsKey(operation)){
            throw new RuntimeException("Unknown operation");
        }
        return registry.get(operation);
    }
}
