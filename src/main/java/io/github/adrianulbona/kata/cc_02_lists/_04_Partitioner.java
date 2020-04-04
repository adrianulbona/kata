package io.github.adrianulbona.kata.cc_02_lists;

import java.util.function.BiFunction;
import java.util.function.Predicate;

class _04_Partitioner implements BiFunction<Node, Integer, Node> {

    @Override
    public Node apply(Node node, Integer key) {
        if (Node.NIL.equals(node)) {
            return Node.NIL;
        }

        final Predicate<Node> smallerDetector = n -> n.value() < key;
        final Node left = node.filter(smallerDetector);
        final Node right = node.filter(smallerDetector.negate());
        return left.append(right);
    }
}
