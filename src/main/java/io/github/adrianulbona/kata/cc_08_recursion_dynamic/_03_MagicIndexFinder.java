package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class _03_MagicIndexFinder implements Function<List<Integer>, Optional<Integer>> {

    @Override
    public Optional<Integer> apply(List<Integer> integers) {

        return apply(integers, 0);
    }

    private Optional<Integer> apply(List<Integer> integers, int index) {
        if (index >= integers.size()) {
            return Optional.empty();
        }

        final Integer value = integers.get(index);
        if (value.equals(index)) {
            return Optional.of(index);
        }

        return apply(integers, value < index ? index + 1 : value);
    }
}
