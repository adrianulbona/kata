package io.github.adrianulbona.kata.cc_3_stacks_queues;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
class StackImpl<E> implements Stack<E> {

    private final int capacity;
    private final List<E> data;

    static <E> Stack<E> withCapacity(int capacity) {
        return new StackImpl<>(capacity, new ArrayList<>());
    }

    static <E> Stack<E> create() {
        return withCapacity(10);
    }

    @Override
    public void push(E x) {
        if (data.size() == capacity) {
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
    public E get(int index) {
        return this.data.get(index);
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.capacity == this.data.size();
    }
}
