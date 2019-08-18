package io.github.adrianulbona.kata.cc_3_stacks_queues;

public interface Stack<E> {

    void push(E x);

    E peek();

    E pop();

    boolean isEmpty();
}
