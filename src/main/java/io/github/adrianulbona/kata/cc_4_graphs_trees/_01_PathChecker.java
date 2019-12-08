package io.github.adrianulbona.kata.cc_4_graphs_trees;

import lombok.Data;

import java.util.*;
import java.util.function.BiPredicate;

@Data
public class _01_PathChecker implements BiPredicate<Integer, Integer> {

    private final Map<Integer, List<Integer>> graph;

    @Override
    public boolean test(Integer from, Integer to) {
        return test(from, to, new HashSet<>());
    }

    private boolean test(Integer from, Integer to, Set<Integer> visited) {
        if (from.equals(to)) {
            return true;
        }

        visited.add(from);
        return graph.getOrDefault(from, List.of()).stream()
                .filter(neighbour -> !visited.contains(neighbour))
                .anyMatch(neighbour -> test(neighbour, to, visited));
    }
}
