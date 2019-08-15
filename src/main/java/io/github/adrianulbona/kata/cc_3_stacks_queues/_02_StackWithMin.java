package io.github.adrianulbona.kata.cc_3_stacks_queues;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class _02_StackWithMin implements Stack {
    private final Stack stack;
    private final Stack mins;

    static _02_StackWithMin create() {
        return new _02_StackWithMin(StackImpl.create(), StackImpl.create());
    }

    @Override
    public void push(int x) {
        this.stack.push(x);
        this.mins.push(this.mins.isEmpty() ? x : Math.min(x, this.mins.peek()));
    }

    @Override
    public int peek() {
        return this.stack.peek();
    }

    @Override
    public int pop() {
        this.mins.pop();
        return this.stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    int min() {
        return this.mins.peek();
    }
}
