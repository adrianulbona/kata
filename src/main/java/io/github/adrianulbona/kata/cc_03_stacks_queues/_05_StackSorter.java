package io.github.adrianulbona.kata.cc_03_stacks_queues;

import java.util.function.Function;

class _05_StackSorter implements Function<Stack<Integer>, Stack<Integer>> {

    @Override
    public Stack<Integer> apply(Stack<Integer> stack) {
        final Stack<Integer> buffer = StackImpl.create();
        while (!bubble(stack, buffer)) { }
        return stack;
    }

    private boolean bubble(Stack<Integer> stack, Stack<Integer> buffer) {
        boolean sorted = true;
        while (!stack.isEmpty()) {
            final Integer head = stack.pop();
            if (!buffer.isEmpty() && head < buffer.peek()) {
                final Integer max = buffer.pop();
                buffer.push(head);
                buffer.push(max);
                sorted = false;
            } else {
                buffer.push(head);
            }
        }
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
        return sorted;
    }
}
