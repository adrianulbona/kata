package io.github.adrianulbona.kata.cc_1_arrays_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class _08_ZeroBroadcaster implements Function<int[][], int[][]> {

    @Override
    public int[][] apply(int[][] matrix) {
        final int rows = matrix.length;
        final int columns = rows > 0 ? matrix[0].length : 0;
        final Set<Integer> rowsWithZeros = new HashSet<>();
        final Set<Integer> columnsWithZeros = new HashSet<>();
        range(0, rows)
                .forEach(row -> range(0, columns)
                        .filter(column -> matrix[row][column] == 0)
                        .forEach(column -> {
                            rowsWithZeros.add(row);
                            columnsWithZeros.add(column);
                        }));

        final int[][] target = clone(matrix);
        range(0, rows)
                .forEach(row -> range(0, columns)
                        .filter(column -> rowsWithZeros.contains(row) || columnsWithZeros.contains(column))
                        .forEach(column -> target[row][column] = 0));
        return target;
    }

    private int[][] clone(int[][] matrix) {
        return stream(matrix)
                .map(row -> Arrays.copyOf(row, row.length)).toArray(int[][]::new);
    }
}
