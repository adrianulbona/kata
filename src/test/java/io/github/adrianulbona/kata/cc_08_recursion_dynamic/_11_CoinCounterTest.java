package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _11_CoinCounterTest {

    private BiFunction<Integer, List<Integer>, Integer> counter;

    private List<Integer> coins;

    @BeforeEach
    void setUp() {
        this.counter = new _11_CoinCounter();
        this.coins = List.of(25, 10, 5, 1);
    }

    @Test
    void apply1() {
        assertEquals(1, this.counter.apply(1, this.coins));
    }

    @Test
    void apply5() {
        assertEquals(2, this.counter.apply(5, this.coins));
    }

    @Test
    void apply10() {
        assertEquals(4, this.counter.apply(10, this.coins));
    }

    @Test
    void apply100() {
        assertEquals(242, this.counter.apply(100, this.coins));
    }
}
