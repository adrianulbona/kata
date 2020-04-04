package io.github.adrianulbona.kata.cc_01_arrays_strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.github.adrianulbona.kata.cc_01_arrays_strings._06_StringCompressor.Counter.counter;
import static java.util.stream.IntStream.range;

class _06_StringCompressor implements Function<String, String> {

    @Override
    public String apply(String s) {
        final LinkedList<Counter> countStack = new LinkedList<>();
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

    private Counter safePeek(Deque<Counter> counts) {
        return Optional.ofNullable(counts.peek()).orElseThrow();
    }

    private void pushIfDifferent(Deque<Counter> counts, char currentChar) {
        final Optional<Counter> optionalPeek = Optional.ofNullable(counts.peek());
        final boolean firstChar = optionalPeek.isEmpty();
        final boolean differentChar = optionalPeek.filter(peek -> peek.character() != currentChar).isPresent();
        if (firstChar || differentChar) {
            counts.push(counter(currentChar));
        }
    }

    record Counter(char character, AtomicInteger count) {

        static final Counter START = counter('*');

        void increment() {
            this.count.incrementAndGet();
        }

        static Counter counter(char character) {
            return new Counter(character, new AtomicInteger());
        }

        @Override
        public String toString() {
            return String.format("%s%d", character, count.get());
        }
    }
}
