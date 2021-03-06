package io.github.adrianulbona.kata.cc_10_sort_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class _02_AnagramsSorter implements Function<List<String>, List<String>> {

    @Override
    public List<String> apply(List<String> anagrams) {
        return anagrams.stream()
                .map(this::sort)
                .sorted(Comparator.comparing(a -> a.sorted))
                .map(SortedString::raw)
                .collect(Collectors.toList());
    }

    private SortedString sort(String string) {
        final char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new SortedString(new String(chars), string);
    }

    record SortedString(String sorted, String raw){
    }
}
