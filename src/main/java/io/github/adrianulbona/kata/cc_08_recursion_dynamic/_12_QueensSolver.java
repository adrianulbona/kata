package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.github.adrianulbona.kata.cc_08_recursion_dynamic.Coord.coord;
import static java.lang.Math.abs;
import static java.util.stream.Collectors.toList;
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

    private Stream<Coord> candidates(List<Coord> queens) {
        return range(0, 8)
                .mapToObj(col -> coord(queens.size(), col))
                .filter(candidate -> !conflict(queens, candidate));
    }

    private boolean conflict(List<Coord> queens, Coord candidate) {
        return queens.stream()
                .anyMatch(queen -> attacking(queen, candidate));
    }

    private boolean attacking(Coord queen, Coord otherQueen) {
        return queen.row() == otherQueen.row()
                || queen.col() == otherQueen.col()
                || (abs(queen.row() - otherQueen.row()) == abs(queen.col() - otherQueen.col()));
    }

    private List<Coord> extend(List<Coord> queens, Coord candidate) {
        return concat(queens.stream(), of(candidate)).collect(toList());
    }
}
