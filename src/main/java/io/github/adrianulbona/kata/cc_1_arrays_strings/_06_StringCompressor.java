package io.github.adrianulbona.kata.cc_1_arrays_strings;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class _06_StringCompressor implements Function<String, String> {

    @Override
    public String apply(String s) {
        final LinkedList<CharacterCount> countStack = new LinkedList<>();
        range(0, s.length())
                .forEach(index -> {
                    final char currentChar = s.charAt(index);
                    pushIfDifferent(countStack, currentChar);
                    safePeek(countStack).increment();
                });

        final int stackSize = countStack.size();
        if (stackSize * 2 < s.length()) {
            return IntStream.range(0, stackSize)
                    .mapToObj(index -> countStack.get(stackSize - index - 1).toString())
                    .collect(Collectors.joining());
        }
        return s;
    }

    private CharacterCount safePeek(Deque<CharacterCount> counts) {
        return Optional.ofNullable(counts.peek()).orElseThrow();
    }

    private void pushIfDifferent(Deque<CharacterCount> counts, char currentChar) {
        final Optional<CharacterCount> optionalPeek = Optional.ofNullable(counts.peek());
        final boolean firstChar = optionalPeek.isEmpty();
        final boolean differentChar = optionalPeek.filter(peek -> peek.character() != currentChar).isPresent();
        if (firstChar || differentChar) {
            counts.push(new CharacterCount(currentChar));
        }
    }

    @Data
    private static class CharacterCount {

        static final CharacterCount START = new CharacterCount('*');

        private final char character;
        private int count = 0;

        void increment() {
            count++;
        }

        @Override
        public String toString() {
            return String.format("%s%d", character, count);
        }
    }
}
