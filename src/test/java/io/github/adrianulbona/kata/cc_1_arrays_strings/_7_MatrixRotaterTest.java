package io.github.adrianulbona.kata.cc_1_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _7_MatrixRotaterTest {

    private Function<int[][], int[][]> rotator;

    @BeforeEach
    void setUp() {
        this.rotator = new _7_MatrixRotater();
    }

    @Test
    void applyEmpty() {
        final int[][] matrix = {};
        assertArrayEquals(matrix, this.rotator.apply(new int[][]{}));
    }

    @Test
    void apply1x1() {
        final int[][] matrix = {{1}};
        assertArrayEquals(matrix, this.rotator.apply(new int[][]{{1}}));
    }

    @Test
    void apply3x3() {
        final int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        final int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        final int[][] actual = this.rotator.apply(input);
        assertArrayEquals(expected, actual);
    }
}