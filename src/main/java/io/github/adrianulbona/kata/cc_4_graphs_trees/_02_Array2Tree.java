package io.github.adrianulbona.kata.cc_4_graphs_trees;

import java.util.Optional;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static java.util.Optional.empty;

public class _02_Array2Tree implements Function<int[], Optional<Node>> {

    @Override
    public Optional<Node> apply(int[] sortedArray) {
        return transform(sortedArray, 0, sortedArray.length);
    }

    private Optional<Node> transform(int[] sortedArray, int start, int end) {
        if (start >= end) {
            return empty();
        }

        final int middle = (start + end) / 2;
        final Optional<Node> left = transform(sortedArray, start, middle);
        final Optional<Node> right = transform(sortedArray, middle + 1, end);
        return Optional.of(node(sortedArray[middle], left, right));
    }
}
