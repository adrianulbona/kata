package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.List;
import java.util.function.BiFunction;

import static java.util.stream.IntStream.rangeClosed;

class _11_CoinCounter implements BiFunction<Integer, List<Integer>, Integer> {

    @Override
    public Integer apply(Integer n, List<Integer> coins) {
        if (coins.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (n == 0 || coins.size() == 1) {
            return 1;
        }
        final Integer coin = coins.get(0);
        final List<Integer> restOfCoins = coins.subList(1, coins.size());
        return rangeClosed(0, n / coin)
                .map(usedCoins -> apply(n - usedCoins * coin, restOfCoins))
                .sum();
    }
}
