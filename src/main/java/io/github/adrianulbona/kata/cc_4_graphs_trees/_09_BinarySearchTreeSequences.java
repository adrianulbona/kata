package io.github.adrianulbona.kata.cc_4_graphs_trees;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.NIL;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableSet;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class _09_BinarySearchTreeSequences implements Function<Node, Set<List<Integer>>> {

    @Override
    public Set<List<Integer>> apply(Node node) {
        if (NIL.equals(node)) {
            return Set.of(List.of());
        }

        final Set<List<Integer>> sequencesLeft = apply(node.left());
        final Set<List<Integer>> sequencesRight = apply(node.right());
        final Set<List<Integer>> nodeAndSequencesLeftFirst = prependNode(node, sequencesLeft, sequencesRight);
        final Set<List<Integer>> nodeAndSequencesRightFirst = prependNode(node, sequencesRight, sequencesLeft);
        return concat(nodeAndSequencesLeftFirst.stream(), nodeAndSequencesRightFirst.stream())
                .collect(toUnmodifiableSet());
    }

    private Set<List<Integer>> prependNode(Node node, Set<List<Integer>> firstSequences, Set<List<Integer>> secondSequences) {
        return firstSequences.stream()
                .flatMap(first -> secondSequences.stream()
                        .map(second -> concat(concat(of(node.value()), first.stream()), second.stream())
                                .collect(toUnmodifiableList())))
                .collect(toUnmodifiableSet());
    }
}
