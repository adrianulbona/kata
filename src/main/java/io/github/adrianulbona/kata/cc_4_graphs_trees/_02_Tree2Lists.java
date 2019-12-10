package io.github.adrianulbona.kata.cc_4_graphs_trees;

import java.util.*;
import java.util.function.Function;

public class _02_Tree2Lists implements Function<Node, Map<Integer, List<Integer>>> {

    @Override
    public Map<Integer, List<Integer>> apply(Node node) {
        final Map<Integer, List<Integer>> accumulator = new HashMap<>();
        accumulate(Optional.ofNullable(node), 1, accumulator);
        return accumulator;
    }

    private void accumulate(Optional<Node> optionalNode, int level, Map<Integer, List<Integer>> accumulator) {
        optionalNode.ifPresent(node -> {
            accumulate(node.left(), level + 1, accumulator);
            accumulator.putIfAbsent(level, new LinkedList<>());
            accumulator.get(level).add(node.value());
            accumulate(node.right(), level + 1, accumulator);
        });
    }
}
