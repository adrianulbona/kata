package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

class _04_PowerSetFinder implements Function<Set<Integer>, Set<Set<Integer>>> {

    @Override
    public Set<Set<Integer>> apply(Set<Integer> set) {
        return streamSubsets(set)
                .collect(toSet());
    }

    private Stream<Set<Integer>> streamSubsets(Set<Integer> set) {
        if (set.isEmpty()) {
            return of(Set.of());
        }

        final Stream<Set<Integer>> partialSubsets = set.stream()
                .map(toBeRemoved -> set.stream().filter(el -> !el.equals(toBeRemoved)).collect(toSet()))
                .flatMap(this::streamSubsets);
        return concat(partialSubsets, of(set));
    }
}
