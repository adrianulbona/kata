package io.github.adrianulbona.kata.cc_5_bits;

import java.util.function.Predicate;

public class _05_Pow2Checker implements Predicate<Integer> {

    @Override
    public boolean test(Integer n) {
        return (n & (n - 1)) == 0;
    }
}