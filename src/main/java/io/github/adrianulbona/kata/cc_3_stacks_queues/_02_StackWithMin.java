package io.github.adrianulbona.kata.cc_3_stacks_queues;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class _02_StackWithMin implements Stack<Integer> {
    private final Stack<Integer> stack;
    private final Stack<Integer> mins;

    static _02_StackWithMin create() {
        return new _02_StackWithMin(StackImpl.create(), StackImpl.create());
    }

    @Override
    public void push(Integer x) {
        this.stack.push(x);
        this.mins.push(this.mins.isEmpty() ? x : Math.min(x, this.mins.peek()));
    }

    @Override
    public Integer peek() {
        return this.stack.peek();
    }

    @Override
    public Integer pop() {
        this.mins.pop();
        return this.stack.pop();
    }

    @Override
    public Integer get(int index) {
        return this.stack.get(index);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.stack.isFull();
    }

    int min() {
        return this.mins.peek();
    }
}
