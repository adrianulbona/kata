package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.*;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;

public class _03_Tree2Lists implements Function<Node, Map<Integer, List<Integer>>> {

    @Override
    public Map<Integer, List<Integer>> apply(Node node) {
        final Map<Integer, List<Integer>> accumulator = new HashMap<>();
        accumulate(node, 1, accumulator);
        return accumulator;
    }

    private void accumulate(Node node, int level, Map<Integer, List<Integer>> accumulator) {
        if (!NIL.equals(node)) {
            accumulate(node.left(), level + 1, accumulator);
            accumulator.putIfAbsent(level, new LinkedList<>());
            accumulator.get(level).add(node.value());
            accumulate(node.right(), level + 1, accumulator);
        }
    }
}
