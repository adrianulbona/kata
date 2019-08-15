package io.github.adrianulbona.kata.cc_3_stacks_queues;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class StackImpl implements Stack {

    private final int capacity;
    private final int[] data;

    private int size = 0;

    static StackImpl withCapacity(int capacity) {
        return new StackImpl(capacity, new int[capacity]);
    }

    static StackImpl create() {
        return new StackImpl(10, new int[10]);
    }

    @Override
    public void push(int x) {
        if (size + 1 == capacity) {
            throw new RuntimeException("Stack full");
        }
        this.data[this.size++] = x;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack empty");
        }
        return this.data[this.size - 1];
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack empty");
        }
        return this.data[--this.size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
