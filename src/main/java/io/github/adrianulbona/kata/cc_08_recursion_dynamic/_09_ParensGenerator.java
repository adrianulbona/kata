package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

class _09_ParensGenerator implements Function<Integer, Stream<String>> {

    @Override
    public Stream<String> apply(Integer n) {
        if (n == 0) {
            return of("");
        }

        return apply(n - 1).flatMap(this::wrapParens);
    }

    private Stream<String> wrapParens(String parens) {
        return of("()" + parens, parens + "()", "(" + parens + ")").distinct();
    }
}
