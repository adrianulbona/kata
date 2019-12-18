package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.function.Function;

import static java.util.stream.IntStream.rangeClosed;

public class _01_StepSequenceCounter implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer n) {
        int[] partial = new int[]{1, 2, 4};

        if (n < 1) {
            return 0;
        }

        if (n < 4) {
            return partial[n - 1];
        }

        rangeClosed(4, n).forEach(k -> {
            int kPartial = partial[0] + partial[1] + partial[2];
            partial[0] = partial[1];
            partial[1] = partial[2];
            partial[2] = kPartial;
        });

        return partial[2];
    }
}
