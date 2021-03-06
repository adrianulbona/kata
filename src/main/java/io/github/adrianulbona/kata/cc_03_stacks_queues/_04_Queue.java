package io.github.adrianulbona.kata.cc_03_stacks_queues;

record _04_Queue<E>(Stack<E> stack, Stack<E> buffer) implements Queue<E> {

    static <E> _04_Queue<E> create() {
        return new _04_Queue<>(StackImpl.create(), StackImpl.create());
    }

    @Override
    public void add(E e) {
        this.stack.push(e);
    }

    @Override
    public E poll() {
        moveAll(this.stack, this.buffer);
        final E peek = this.buffer.pop();
        moveAll(this.buffer, this.stack);
        return peek;
    }

    @Override
    public E peek() {
        moveAll(this.stack, this.buffer);
        final E peek = this.buffer.peek();
        moveAll(this.buffer, this.stack);
        return peek;
    }

    private void moveAll(Stack<E> from, Stack<E> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
