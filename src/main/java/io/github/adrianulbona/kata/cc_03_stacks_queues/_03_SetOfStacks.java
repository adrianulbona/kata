package io.github.adrianulbona.kata.cc_03_stacks_queues;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class _03_SetOfStacks<E> implements Stack<E> {

    private final Stack<Stack<E>> stacks;

    static <E> _03_SetOfStacks<E> create() {
        return new _03_SetOfStacks<>(StackImpl.create());
    }

    @Override
    public void push(E x) {
        if (this.stacks.isEmpty() || this.stacks.peek().isFull()) {
            this.stacks.push(StackImpl.create());
        }
        this.stacks.peek().push(x);
    }

    @Override
    public E peek() {
        return this.stacks.peek().peek();
    }

    @Override
    public E pop() {
        final E e = this.stacks.peek().pop();
        if (this.stacks.peek().isEmpty()) {
            this.stacks.pop();
        }
        return e;
    }

    @Override
    public E get(int index) {
        return this.stacks.get(index).peek();
    }

    @Override
    public boolean isEmpty() {
        return this.stacks.isEmpty() ;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    E popAt(int index) {
        return this.stacks.get(index).pop();
    }
}
