package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.function.Predicate;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;

class _04_BalancedTreeChecker implements Predicate<Node> {

    @Override
    public boolean test(Node node) {
        return checkBalanced(node).balanced;
    }

    private BalancedStatus checkBalanced(Node node) {
        if (NIL.equals(node)) {
            return new BalancedStatus(true, 0);
        }

        final BalancedStatus balancedStatusLeft = checkBalanced(node.left());
        final BalancedStatus balancedStatusRight = checkBalanced(node.right());
        final int height = Math.max(balancedStatusLeft.height, balancedStatusRight.height) + 1;
        if (balancedStatusLeft.balanced
                && balancedStatusRight.balanced
                && Math.abs(balancedStatusLeft.height - balancedStatusRight.height) < 2) {
            return new BalancedStatus(true, height);
        }
        return new BalancedStatus(false, height);
    }

    private record BalancedStatus(boolean balanced, int height) {
    }
}
