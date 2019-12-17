package io.github.adrianulbona.kata.cc_5_bits;

class _04_NextFinder {

    int greater(int bits) {
        final int targetOnes = numberOfOnes(bits);
        int greater = bits + 1;
        while (numberOfOnes(greater) != targetOnes) {
            greater++;
        }
        return greater;
    }

    int smaller(int bits) {
        final int targetOnes = numberOfOnes(bits);
        int smaller = bits - 1;
        while (numberOfOnes(smaller) != targetOnes || smaller < (1 << targetOnes)) {
            smaller--;
        }
        if (numberOfOnes(smaller) != targetOnes) {
            throw new IllegalArgumentException();
        }
        return smaller;
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
