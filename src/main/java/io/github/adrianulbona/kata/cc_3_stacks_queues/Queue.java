package io.github.adrianulbona.kata.cc_3_stacks_queues;

public interface Queue<E> {

    void add(E e);

    E poll();

    E peek();
}
