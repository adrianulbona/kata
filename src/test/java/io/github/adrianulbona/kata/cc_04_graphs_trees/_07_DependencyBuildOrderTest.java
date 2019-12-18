package io.github.adrianulbona.kata.cc_04_graphs_trees;

import io.github.adrianulbona.kata.cc_04_graphs_trees._07_DependencyBuildOrder.Dependency;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_04_graphs_trees._07_DependencyBuildOrder.Dependency.dep;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _07_DependencyBuildOrderTest {

    @Test
    void applyScenario1() {
        final BiFunction<Set<String>, List<Dependency>, List<Set<String>>> builder = new _07_DependencyBuildOrder();

        final Set<String> projects = Set.of("a", "b", "c", "d", "e", "f");
        final List<Dependency> dependencies = List.of(
                dep("a", "d"),
                dep("f", "b"),
                dep("b", "d"),
                dep("f", "a"),
                dep("d", "c"));

        final List<Set<String>> buildOrder = List.of(Set.of("f", "e"), Set.of("a", "b"), Set.of("d"), Set.of("c"));
        assertEquals(buildOrder, builder.apply(projects, dependencies));
    }

    @Test
    void applyScenario2() {
        final BiFunction<Set<String>, List<Dependency>, List<Set<String>>> builder = new _07_DependencyBuildOrder();

        final Set<String> projects = Set.of("a", "b", "c", "d", "e", "f", "g");
        final List<Dependency> dependencies = List.of(
                dep("d", "g"),
                dep("f", "c"),
                dep("f", "b"),
                dep("f", "a"),
                dep("c", "a"),
                dep("b", "a"),
                dep("a", "e"),
                dep("b", "e"));

        final List<Set<String>> buildOrder = List.of(Set.of("f", "d"), Set.of("c", "b", "g"), Set.of("a"), Set.of("e"));
        assertEquals(buildOrder, builder.apply(projects, dependencies));
    }
}