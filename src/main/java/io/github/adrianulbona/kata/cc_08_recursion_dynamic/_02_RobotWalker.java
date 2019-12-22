package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Coord;
import static io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Grid;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

class _02_RobotWalker implements Function<Grid, Set<List<Coord>>> {

    @Override
    public Set<List<Coord>> apply(Grid grid) {
        return explore(List.of(Coord.coord(0, 0)), grid)
                .collect(Collectors.toSet());
    }

    private Stream<List<Coord>> explore(List<Coord> path, Grid grid) {
        final Coord currentCell = path.get(path.size() - 1);
        if (currentCell.equals(grid.destination())) {
            return Stream.of(path);
        }

        return grid.explore(currentCell).stream()
                .map(neighbour -> concat(path.stream(), of(neighbour)).collect(toList()))
                .flatMap(extendedPath -> explore(extendedPath, grid));
    }

    @Data
    static class Coord {

        private final int row;
        private final int col;

        static Coord coord(int row, int col) {
            return new Coord(row, col);
        }

        Coord down() {
            return coord(this.row + 1, this.col);
        }

        Coord right() {
            return coord(this.row, this.col + 1);
        }

    }

    @Data
    static class Grid {

        private final int rows;
        private final int columns;
        private final Set<Coord> offLimitCells;

        static Grid of(int rows, int columns, Set<Coord> offLimitCells) {
            return new Grid(rows, columns, offLimitCells);
        }

        Coord destination() {
            return Coord.coord(rows - 1, columns - 1);
        }

        List<Coord> explore(Coord coord) {
            if (!valid(coord)) {
                throw new IllegalArgumentException();
            }

            return Stream.of(coord.down(), coord.right())
                    .filter(this::valid)
                    .collect(toList());
        }

        private boolean valid(Coord coord) {
            return !this.offLimitCells.contains(coord) && coord.row < this.rows && coord.col < this.columns;
        }
    }
}
