package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.github.adrianulbona.kata.cc_08_recursion_dynamic.Coord.coord;
import static java.lang.Math.abs;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class _12_QueensSolver implements Function<List<Coord>, Stream<List<Coord>>> {

    @Override
    public Stream<List<Coord>> apply(List<Coord> queens) {
        if (queens.size() == 8) {
            return of(queens);
        }
        return candidates(queens)
                .flatMap(candidate -> apply(extend(queens, candidate)));
    }

    private List<Coord> extend(List<Coord> queens, Coord candidate) {
        return concat(queens.stream(), of(candidate)).collect(toList());
    }

    private Stream<Coord> candidates(List<Coord> queens) {
        final Set<Integer> cols = queens.stream().map(Coord::col).collect(toSet());
        return range(0, 8)
                .mapToObj(col -> coord(queens.size(), col))
                .filter(candidate -> !cols.contains(candidate.col()) && !diagonalConflict(queens, candidate));
    }

    private boolean diagonalConflict(List<Coord> queens, Coord candidate) {
        return queens.stream()
                .anyMatch(queen -> abs(candidate.row() - queen.row()) == abs(candidate.col() - queen.col()));
    }
}
