package io.github.adrianulbona.kata.cc_04_graphs_trees;

import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.adrianulbona.kata.cc_04_graphs_trees._07_DependencyBuildOrder.Dependency;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableSet;
import static java.util.stream.Stream.concat;

public class _07_DependencyBuildOrder
        implements BiFunction<Set<String>, List<Dependency>, List<Set<String>>> {

    @Override
    public List<Set<String>> apply(Set<String> projects, List<Dependency> dependencies) {
        if (projects.isEmpty()) {
            return List.of();
        }

        final Set<String> projectsWithoutDependencies = projects.stream()
                .filter(project -> dependencies.stream().noneMatch(dependency -> dependency.to.equals(project)))
                .collect(Collectors.toUnmodifiableSet());

        final Set<String> remainingProjects = projects.stream()
                .filter(project -> !projectsWithoutDependencies.contains(project))
                .collect(toUnmodifiableSet());

        final List<Dependency> remainingDependencies = dependencies.stream()
                .filter(dependency -> !projectsWithoutDependencies.contains(dependency.from))
                .collect(toUnmodifiableList());

        return concat(Stream.of(projectsWithoutDependencies), apply(remainingProjects, remainingDependencies).stream())
                .collect(toUnmodifiableList());
    }

    @Data
    static class Dependency {
        private final String from;
        private final String to;

        static Dependency dep(String from, String to) {
            return new Dependency(from, to);
        }
    }
}
