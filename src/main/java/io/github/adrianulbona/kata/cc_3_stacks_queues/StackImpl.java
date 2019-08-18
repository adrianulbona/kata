package io.github.adrianulbona.kata.cc_3_stacks_queues;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class StackImpl<E> implements Stack<E> {

    private final int capacity;
    private final List<E> data;

    static <E> StackImpl<E> withCapacity(int capacity) {
        return new StackImpl<>(capacity, new ArrayList<>());
    }

    static <E> StackImpl<E> create() {
        return withCapacity(10);
    }

    @Override
    public void push(E x) {
        if (data.size() + 1 == capacity) {
            throw new RuntimeException("Stack full");
        }
        this.data.add(x);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack empty");
        }
        return this.data.get(this.data.size() - 1);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack empty");
        }
        return this.data.remove(this.data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
