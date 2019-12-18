package io.github.adrianulbona.kata.cc_05_bits;

import java.util.function.BiFunction;

public class _06_FlipMatcher implements BiFunction<Integer, Integer, Integer> {

    @Override
    public Integer apply(Integer source, Integer target) {
        return numberOfOnes(source ^ target);
    }

    private int numberOfOnes(int bits) {
        int count = 0;
        while (bits > 0) {
            count += bits & 1;
            bits >>= 1;
        }
        return count;
    }
}
