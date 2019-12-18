package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;

public class _08_FirstCommonAccestor implements BiFunction<Node, Node, Node> {

    @Override
    public Node apply(Node first, Node second) {
        if (NIL.equals(first) || NIL.equals(second)) {
            return NIL;
        }

        if (ancestor(first, second)) {
            return first;
        }

        return apply(first.parent(), second);
    }

    private boolean ancestor(Node ancestor, Node descendant) {
        if (NIL.equals(ancestor) || NIL.equals(descendant)) {
            return false;
        }
        if (ancestor.equals(descendant)) {
            return true;
        }
        return ancestor(ancestor, descendant.parent());
    }
}
