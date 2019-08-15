package io.github.adrianulbona.kata.cc_3_stacks_queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _02_StackWithMinTest {

    @Test
    void minEmpty() {
        assertThrows(RuntimeException.class, () -> _02_StackWithMin.create().min());
    }

    @Test
    void minOnTop() {
        final _02_StackWithMin stackWithMin = _02_StackWithMin.create();
        stackWithMin.push(3);
        stackWithMin.push(2);
        stackWithMin.push(1);

        assertEquals(1, stackWithMin.min());
    }

    @Test
    void minFirst() {
        final _02_StackWithMin stackWithMin = _02_StackWithMin.create();
        stackWithMin.push(1);
        stackWithMin.push(2);
        stackWithMin.push(3);

        assertEquals(1, stackWithMin.min());
    }
}
