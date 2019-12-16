package io.github.adrianulbona.kata.cc_4_graphs_trees;

import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class _11_RandomChildSampler implements Function<Node, Node> {

    private final Function<Integer, Integer> intSampler;

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
