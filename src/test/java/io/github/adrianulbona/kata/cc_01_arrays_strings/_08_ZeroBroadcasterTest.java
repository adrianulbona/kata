package io.github.adrianulbona.kata.cc_01_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _08_ZeroBroadcasterTest {

    private Function<int[][], int[][]> broadcaster;

    @BeforeEach
    void setUp() {
        this.broadcaster = new _08_ZeroBroadcaster();
    }

    @Test
    void applyEmpty() {
        final int[][] matrix = {};
        assertArrayEquals(matrix, this.broadcaster.apply(new int[][]{}));
    }

    @Test
    void apply1x1WithoutZero() {
        final int[][] matrix = {{1}};
        assertArrayEquals(matrix, this.broadcaster.apply(new int[][]{{1}}));
    }

    @Test
    void apply1x1WithZero() {
        final int[][] matrix = {{0}};
        assertArrayEquals(matrix, this.broadcaster.apply(new int[][]{{0}}));
    }

    @Test
    void apply3x3() {
        final int[][] expected = {{0, 0, 0, 0}, {0, 0, 0, 0}, {7, 8, 0, 0}};
        final int[][] input = {{1, 2, 3, 0}, {4, 5, 0, 6}, {7, 8, 9, 10}};
        assertArrayEquals(expected, this.broadcaster.apply(input));
    }
}
