package io.github.adrianulbona.kata.cc_03_stacks_queues;

public interface Stack<E> {

    void push(E x);

    E peek();

    E pop();

    E get(int index);

    boolean isEmpty();

    boolean isFull();
}
