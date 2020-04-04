package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;
import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.node;

class _02_Array2Tree implements Function<int[], Node> {

    @Override
    public Node apply(int[] sortedArray) {
        return transform(sortedArray, 0, sortedArray.length);
    }

    private Node transform(int[] sortedArray, int start, int end) {
        if (start >= end) {
            return NIL;
        }

        final int middle = (start + end) / 2;
        final Node left = transform(sortedArray, start, middle);
        final Node right = transform(sortedArray, middle + 1, end);
        return node(sortedArray[middle], left, right);
    }
}
