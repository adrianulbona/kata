package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

class _10_Painter {

    void fill(int[][] image, Coord size, Coord pixel, int source, int target) {
        image[pixel.row()][pixel.col()] = target;
        pixel.neighbours(size)
                .filter(neighbour -> image[neighbour.row()][neighbour.col()] == source)
                .forEach(neighbour -> fill(image, size, neighbour, source, target));
    }
}
