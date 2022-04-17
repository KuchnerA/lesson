package ru.learnUp.feb.learnupjava20.service;

public interface Processor {

    Operation getOperation();

    int process(int a, int b);

}
