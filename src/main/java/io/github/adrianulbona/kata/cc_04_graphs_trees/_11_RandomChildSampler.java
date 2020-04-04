package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.function.Function;

record _11_RandomChildSampler(Function<Integer, Integer> intSampler) implements Function<Node, Node> {

    @Override
    public Node apply(Node node) {
        if (theChosenOne(node.size())) {
            return node;
        }
        if (goLeft(node.left().size(), node.right().size())) {
            return apply(node.left());
        }
        return apply(node.right());
    }

    private boolean theChosenOne(int outOf) {
        return intSampler.apply(outOf) == 0;
    }

    private boolean goLeft(int leftSize, int rightSize) {
        return intSampler.apply(leftSize + rightSize) < leftSize;
    }
}
