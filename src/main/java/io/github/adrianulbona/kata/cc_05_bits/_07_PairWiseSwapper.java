package io.github.adrianulbona.kata.cc_05_bits;

import java.util.function.Function;

public class _07_PairWiseSwapper implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer input) {
        int evenBits = 0xAAAAAAAA;
        int oddBits = 0x55555555;
        return (input & evenBits) >> 1 |  (input & oddBits) << 1;
    }
}
