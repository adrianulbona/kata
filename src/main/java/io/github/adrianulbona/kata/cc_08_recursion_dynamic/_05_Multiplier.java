package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.function.BiFunction;

public class _05_Multiplier implements BiFunction<Integer, Integer, Integer> {

    @Override
    public Integer apply(Integer a, Integer b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        if (a == 1 || b == 1) {
            return a + b - 1;
        }

        final int min = Math.min(a, b);
        final int max = Math.max(a, b);

        final int pow2Approx = pow2Approx(min);

        final int remainingMin = min - (1 << pow2Approx);
        return (max << pow2Approx) + apply(max, remainingMin);
    }

    private int pow2Approx(int x) {
        int pow2 = 0;
        while (x > 0) {
            x >>= 1;
            pow2++;
        }
        return pow2 - 1;
    }
}
