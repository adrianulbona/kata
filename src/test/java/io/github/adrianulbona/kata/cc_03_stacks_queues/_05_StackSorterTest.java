package io.github.adrianulbona.kata.cc_03_stacks_queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _05_StackSorterTest {

    @Test
    void testEmpty() {
        final Stack<Integer> stack = StackImpl.create();
        assertEquals(StackImpl.create(), new _05_StackSorter().apply(stack));
    }

    @Test
    void test4321() {
        final Stack<Integer> stack = StackImpl.create();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        final Stack<Integer> expected = StackImpl.create();
        expected.push(4);
        expected.push(3);
        expected.push(2);
        expected.push(1);

        assertEquals(expected, new _05_StackSorter().apply(stack));
    }

    @Test
    void test1243() {
        final Stack<Integer> stack = StackImpl.create();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);

        final Stack<Integer> expected = StackImpl.create();
        expected.push(4);
        expected.push(3);
        expected.push(2);
        expected.push(1);

        assertEquals(expected, new _05_StackSorter().apply(stack));
    }
}
