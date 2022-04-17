package ru.learnUp.feb.learnupjava20.service.processors;

import org.springframework.stereotype.Component;
import ru.learnUp.feb.learnupjava20.service.Operation;
import ru.learnUp.feb.learnupjava20.service.Processor;

@Component
public class SubtractProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.MINUS;
    }

    @Override
    public int process(int a, int b) {
        return a - b;
    }
}
