package com.finsentinel.stream;

public interface EventPublisher<T> {
    void publish(T event);
}
