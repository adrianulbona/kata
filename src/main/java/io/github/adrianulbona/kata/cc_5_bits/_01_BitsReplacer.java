package io.github.adrianulbona.kata.cc_5_bits;

class _01_BitsReplacer {

    int apply(int source, int target, int from, int to) {
        final int mask = ((2 << (from - to) - 1) << to) ^ Integer.MAX_VALUE;
        return (target & mask) | (source << to);
    }
}
