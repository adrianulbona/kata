package io.github.adrianulbona.kata.cc_03_stacks_queues;

import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.junit.jupiter.api.Assertions.*;

class _04_QueueTest {

    @Test
    void testPeek() {
        final _04_Queue<Integer> queue = _04_Queue.create();

        rangeClosed(1, 5).forEach(i -> {
            queue.add(i);
            assertEquals(1, queue.peek());
        });
    }

    @Test
    void testPoll() {
        final _04_Queue<Integer> queue = _04_Queue.create();
        rangeClosed(1, 5).forEach(queue::add);

        rangeClosed(1, 5).forEach(i -> assertEquals(i, queue.poll()));
    }
}
