package io.github.adrianulbona.kata.cc_03_stacks_queues;

record _02_StackWithMin(Stack<Integer> stack, Stack<Integer> mins) implements Stack<Integer> {

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
