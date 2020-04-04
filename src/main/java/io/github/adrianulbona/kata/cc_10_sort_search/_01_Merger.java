package io.github.adrianulbona.kata.cc_10_sort_search;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

class _01_Merger implements BiConsumer<int[], int[]> {

    @Override
    public void accept(int[] a, int[] b) {
        final int sizeB = b.length;
        final int sizeA = a.length - b.length;

        rangeClosed(1, sizeA)
                .forEach(index -> a[a.length - index] = a[sizeA - index]);

        final AtomicInteger indexA = new AtomicInteger(a.length - sizeA);
        final AtomicInteger indexB = new AtomicInteger(0);

        range(0, sizeA + sizeB)
                .forEach(indexDestination -> {
                    if (indexA.get() >= sizeA + sizeB) { // a done
                        a[indexDestination] = b[indexB.getAndIncrement()];
                    } else if (indexB.get() >= sizeB) {  // b done
                        a[indexDestination] = a[indexA.getAndIncrement()];
                    } else if (a[indexA.get()] > b[indexB.get()]) {
                        a[indexDestination] = b[indexB.getAndIncrement()];
                    } else {
                        a[indexDestination] = a[indexA.getAndIncrement()];
                    }
                });
    }
}
