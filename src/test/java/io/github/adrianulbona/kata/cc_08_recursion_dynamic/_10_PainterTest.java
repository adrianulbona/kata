package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.Test;

import static io.github.adrianulbona.kata.cc_08_recursion_dynamic.Coord.coord;
import static org.junit.jupiter.api.Assertions.*;

class _10_PainterTest {

    @Test
    void fill() {
        final int[][] image = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
        };

        final int[][] expected = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 0, 0},
                {0, 0, 0, 2, 2, 2, 0, 0},
                {0, 0, 0, 0, 2, 2, 0, 0},
                {0, 0, 0, 0, 2, 2, 0, 0},
        };

        new _10_Painter().fill(image, coord(8, 8), coord(3, 3), 1, 2);

        assertArrayEquals(expected, image);
    }
}
