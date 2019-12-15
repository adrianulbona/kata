package io.github.adrianulbona.kata.cc_4_graphs_trees;

import java.util.function.Predicate;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.NIL;

public class _05_BinarySearchTreeChecker implements Predicate<Node> {

    @Override
    public boolean test(Node node) {
        return test(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean test(Node node, int min, int max) {
        if (NIL.equals(node)) {
            return true;
        }
        return min <= node.value() && node.value() <= max
                && test(node.left(), min, node.value() - 1)
                && test(node.right(), node.value() + 1, max);
    }
}
