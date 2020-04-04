package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.stream.Stream;

record Coord(int row, int col) {

    static Coord coord(int row, int col) {
        return new Coord(row, col);
    }

    Coord down() {
        return coord(this.row + 1, this.col);
    }

    Coord right() {
        return coord(this.row, this.col + 1);
    }

    Coord up() {
        return coord(this.row - 1, this.col);
    }

    Coord left() {
        return coord(this.row, this.col - 1);
    }

    Stream<Coord> neighbours(Coord size) {
        return Stream.of(down(), left(), up(), right()).filter(neighbour ->
                neighbour.col >= 0
                        && neighbour.row >= 0
                        && neighbour.col < size.col
                        && neighbour.row < size.row);
    }
}
