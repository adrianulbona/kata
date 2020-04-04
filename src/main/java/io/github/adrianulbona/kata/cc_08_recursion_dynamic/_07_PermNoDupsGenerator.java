package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.IntStream.range;

class _07_PermNoDupsGenerator implements Function<String, Stream<String>> {

    @Override
    public Stream<String> apply(String s) {
        if (s.isEmpty()) {
            return Stream.of("");
        }

        return range(0, s.length())
                .mapToObj(index -> apply(substringWithoutChar(s, index))
                        .map(subPerm -> s.charAt(index) + subPerm))
                .flatMap(identity());
    }

    private String substringWithoutChar(String s, int index) {
        final String pre = index > 0 ? s.substring(0, index) : "";
        final String post = index < s.length() - 1 ? s.substring(index + 1) : "";
        return pre + post;
    }
}
