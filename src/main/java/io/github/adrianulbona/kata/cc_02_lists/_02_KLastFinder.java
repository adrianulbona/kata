package io.github.adrianulbona.kata.cc_02_lists;

import java.util.function.BiFunction;

class _02_KLastFinder implements BiFunction<Integer, Node, Node> {

    @Override
    public Node apply(Integer k, Node node) {
        final int size = node.size();
        return node.get(size - k);
    }
}
