package io.github.adrianulbona.kata.cc_2_lists;

import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_2_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_2_lists.Node.node;

public class _01_DuplicatesRemover implements Function<Node, Node> {

    @Override
    public Node apply(Node node) {
        if (NIL.equals(node)) {
            return node;
        }

        return node(node.value(), apply(node.next().removeAll(node.value())));
    }
}
