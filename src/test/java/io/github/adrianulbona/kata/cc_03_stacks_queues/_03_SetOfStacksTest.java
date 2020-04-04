package io.github.adrianulbona.kata.cc_03_stacks_queues;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static org.junit.jupiter.api.Assertions.*;

class _03_SetOfStacksTest {

    @Test
    void pushPeekPop() {
        final Stack<Integer> setOfStacks = _03_SetOfStacks.create();
        rangeClosed(1, 12)
                .forEach(x -> {
                    setOfStacks.push(x);
                    assertEquals(x, setOfStacks.peek());
                });

        rangeClosed(1, 12).boxed().sorted(Collections.reverseOrder())
                .forEach(x -> assertEquals(x, setOfStacks.pop()));

        assertTrue(setOfStacks.isEmpty());
    }

    @Test
    void pushPopAt() {
        final _03_SetOfStacks<Integer> setOfStacks = _03_SetOfStacks.create();
        rangeClosed(1, 12).forEach(setOfStacks::push);
        assertEquals(10, setOfStacks.popAt(0));

        final List<Integer> restOfElements = rangeClosed(1, 11)
                .mapToObj(__ -> setOfStacks.pop())
                .collect(toList());
        assertEquals(asList(12, 11, 9, 8, 7, 6, 5, 4, 3, 2, 1), restOfElements);
    }
}
