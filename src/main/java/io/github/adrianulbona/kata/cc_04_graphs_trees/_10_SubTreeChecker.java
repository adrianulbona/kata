package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.function.BiPredicate;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;

public class _10_SubTreeChecker implements BiPredicate<Node, Node> {

    @Override
    public boolean test(Node potentialChild, Node tree) {
        if (NIL.equals(tree)) {
            return false;
        }

        if (!potentialChild.value().equals(tree.value())) {
            return test(potentialChild, tree.left()) || test(potentialChild, tree.right());
        }

        return same(potentialChild, tree);
    }

    private boolean same(Node node, Node otherNode) {
        if (NIL.equals(node) && NIL.equals(otherNode)) {
            return true;
        }

        return node.value().equals(otherNode.value())
                && same(node.left(), otherNode.left())
                && same(node.right(), otherNode.right());
    }
}
