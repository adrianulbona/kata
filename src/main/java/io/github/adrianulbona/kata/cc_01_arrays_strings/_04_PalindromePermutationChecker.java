package io.github.adrianulbona.kata.cc_01_arrays_strings;

import java.util.Collection;
import java.util.function.Predicate;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class _04_PalindromePermutationChecker implements Predicate<String> {

    @Override
    public boolean test(String s) {
        final Collection<Long> frequencies = s.chars()
                .filter(c -> c != ' ')
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .values();

        final long unpairedCharsCount = frequencies.stream()
                .filter(count -> count % 2 == 1).count();
        return unpairedCharsCount <= 1;
    }
}
