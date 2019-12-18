package io.github.adrianulbona.kata.cc_01_arrays_strings;

import java.util.Arrays;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class _07_MatrixRotater implements Function<int[][], int[][]> {

    @Override
    public int[][] apply(int[][] matrix) {
        final int[][] target = clone(matrix);
        inPlaceOneEightyOverDiagonal(target);
        inPlaceOneEightyOverVertical(target);
        return target;
    }

    private void inPlaceOneEightyOverDiagonal(int[][] matrix) {
        range(0, matrix.length - 1)
                .forEach(row -> range(row + 1, matrix.length)
                        .forEach(column -> {
                            final int tmp = matrix[row][column];
                            matrix[row][column] = matrix[column][row];
                            matrix[column][row] = tmp;
                        }));
    }

    private void inPlaceOneEightyOverVertical(int[][] matrix) {
        range(0, matrix.length)
                .forEach(row -> range(0, matrix.length / 2)
                        .forEach(column -> {
                            final int tmp = matrix[row][column];
                            matrix[row][column] = matrix[row][matrix.length - 1 - column];
                            matrix[row][matrix.length - 1 - column] = tmp;
                        }));
    }

    private int[][] clone(int[][] matrix) {
        return stream(matrix)
                .map(row -> Arrays.copyOf(row, row.length)).toArray(int[][]::new);
    }
}
