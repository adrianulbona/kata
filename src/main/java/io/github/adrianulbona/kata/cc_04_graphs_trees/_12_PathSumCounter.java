package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;

class _12_PathSumCounter implements BiFunction<Node, Integer, Integer> {

    @Override
    public Integer apply(Node node, Integer sumToFind) {
        return count(node, 0, sumToFind, new HashMap<>());
    }

    private Integer count(Node node, Integer runningSum, Integer sumToFind, Map<Integer, Integer> partialSums) {
        if (NIL.equals(node)) {
            return 0;
        }

        final int currentRunningSum = runningSum + node.value();
        final int extraSum = currentRunningSum - sumToFind;
        final int matchingSubPaths = partialSums.getOrDefault(extraSum, 0)
                + (currentRunningSum == sumToFind ? 1 : 0);

        final int currentRunningSumCount = partialSums.getOrDefault(currentRunningSum, 0);
        partialSums.put(currentRunningSum, currentRunningSumCount + 1);

        final int matchingSubPathsLeft = count(node.left(), currentRunningSum, sumToFind, partialSums);
        final int matchingSubPathsRight = count(node.right(), currentRunningSum, sumToFind, partialSums);

        partialSums.put(currentRunningSum, currentRunningSumCount);

        return matchingSubPaths + matchingSubPathsLeft + matchingSubPathsRight;
    }
}
