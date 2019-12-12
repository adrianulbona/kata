package io.github.adrianulbona.kata.cc_4_graphs_trees;

import java.util.Optional;
import java.util.function.Predicate;

public class _05_BinarySearchTreeChecker implements Predicate<Node> {

    @Override
    public boolean test(Node node) {
        return test(Optional.of(node), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean test(Optional<Node> optionalNode, int min, int max) {
        return optionalNode
                .map(node -> min <= node.value()
                        && node.value() <= max
                        && test(node.left(), min, node.value() - 1)
                        && test(node.right(), node.value() + 1, max)
                ).orElse(true);
    }
}
