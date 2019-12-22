package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Coord;
import static io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Grid;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

class _02_RobotWalker implements Function<Grid, List<Coord>> {

    @Override
    public List<Coord> apply(Grid grid) {
        final HashMap<Coord, List<Coord>> start = new HashMap<>() {{
            put(Coord.of(0, 0), List.of(Coord.of(0, 0)));
        }};
        return explore(grid, start)
                .getOrDefault(grid.destination(), List.of());
    }

    private Map<Coord, List<Coord>> explore(Grid grid, Map<Coord, List<Coord>> paths) {
        if (paths.keySet().contains(grid.destination())) {
            return paths;
        }

        final Map<Coord, List<Coord>> newPaths = new HashMap<>(paths);
        paths.forEach((key, value) -> {
            final List<Coord> neighbours = grid.explore(key);
            neighbours.stream()
                    .filter(neighbour -> !paths.containsKey(neighbour))
                    .forEach(neighbour -> {
                        final List<Coord> newPath = concat(value.stream(), of(neighbour)).collect(toList());
                        newPaths.putIfAbsent(neighbour, newPath);
                        final List<Coord> existingPath = newPaths.get(neighbour);
                        if (existingPath.size() > newPath.size()) {
                            newPaths.put(neighbour, newPath);
                        }
                    });
        });

        return explore(grid, newPaths);
    }

    @Data
    static class Coord {

        private final int row;
        private final int col;

        static Coord of(int row, int col) {
            return new Coord(row, col);
        }

        Coord down() {
            return of(this.row + 1, this.col);
        }

        Coord right() {
            return of(this.row, this.col + 1);
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
            return Coord.of(rows - 1, columns - 1);
        }

        List<Coord> explore(Coord coord) {
            if (!valid(coord)) {
                return List.of();
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
