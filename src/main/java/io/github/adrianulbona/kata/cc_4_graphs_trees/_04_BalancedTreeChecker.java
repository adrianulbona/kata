package io.github.adrianulbona.kata.cc_4_graphs_trees;

import lombok.Data;

import java.util.Optional;
import java.util.function.Predicate;

public class _04_BalancedTreeChecker implements Predicate<Node> {

    @Override
    public boolean test(Node node) {
        return test(Optional.of(node)).balanced;
    }

    private BalancedStatus test(Optional<Node> optionalNode) {
        return optionalNode.map(node -> {
            final BalancedStatus balancedStatusLeft = test(node.left());
            final BalancedStatus balancedStatusRight = test(node.right());
            final int height = Math.max(balancedStatusLeft.height, balancedStatusRight.height) + 1;
            if (balancedStatusLeft.balanced
                    && balancedStatusRight.balanced
                    && Math.abs(balancedStatusLeft.height - balancedStatusRight.height) < 2) {
                return new BalancedStatus(true, height);
            }
            return new BalancedStatus(false, height);
        }).orElse(new BalancedStatus(true, 0));
    }

    @Data
    private static class BalancedStatus {
        private final boolean balanced;
        private final int height;
    }
}
