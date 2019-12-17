package io.github.adrianulbona.kata.cc_5_bits;

import java.util.function.Function;

import static java.lang.Math.max;

class _03_BitFlipper implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer bits) {
        int maxLength = 1;
        int previousLength = 0;
        int currentLength = 0;
        while (bits > 0) {
            if ((bits & 1) == 1) {
                currentLength++;
            } else {
                maxLength = max(previousLength + currentLength + 1, maxLength);
                previousLength = currentLength;
                currentLength = 0;
            }
            bits >>= 1;
        }
        return max(previousLength + currentLength + 1, maxLength);
    }
}
