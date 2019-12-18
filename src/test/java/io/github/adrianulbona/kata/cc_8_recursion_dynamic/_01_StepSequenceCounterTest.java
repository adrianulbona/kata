package io.github.adrianulbona.kata.cc_8_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _01_StepSequenceCounterTest {

    private Function<Integer, Integer> counter;

    @BeforeEach
    void setUp() {
        this.counter = new _01_StepSequenceCounter();
    }

    @Test
    void apply0() {
        assertEquals(0, this.counter.apply(0));
    }

    @Test
    void apply1() {
        assertEquals(1, this.counter.apply(1));
    }


    @Test
    void apply2() {
        assertEquals(2, this.counter.apply(2));
    }


    @Test
    void apply3() {
        assertEquals(4, this.counter.apply(3));
    }

    @Test
    void apply4() {
        assertEquals(7, this.counter.apply(4));
    }

}