package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;

public class _06_SuccessorFinder implements Function<Node, Node> {

    @Override
    public Node apply(Node node) {
        return findSuccessor(node, node);
    }

    private Node findSuccessor(Node origin, Node current) {
        if (NIL.equals(current)) {
            return NIL;
        }
        if (origin.value() < current.value()) {
            return current;
        }
        return findSuccessor(origin, current.parent());
    }
}
