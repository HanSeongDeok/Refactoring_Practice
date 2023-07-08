package org.example.codesmell.dataclumps.example.example_two.solution2;

public interface IFactory<T, R> {
    T create(R factoryImpl);
}
