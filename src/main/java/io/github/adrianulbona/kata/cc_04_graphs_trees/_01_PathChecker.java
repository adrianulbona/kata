package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.*;
import java.util.function.BiPredicate;

record _01_PathChecker(Map<Integer, List<Integer>> graph) implements BiPredicate<Integer, Integer> {

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
