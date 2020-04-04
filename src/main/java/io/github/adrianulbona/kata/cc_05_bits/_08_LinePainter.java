package io.github.adrianulbona.kata.cc_05_bits;

import static java.util.stream.IntStream.rangeClosed;

class _08_LinePainter {

    public long apply(int x1, int y1, int x2, int y2) {
        int xMin = Math.min(x1, x2);
        int xMax = Math.max(x1, x2);
        int b = slope(x1, y1, x2, y2);
        int a = intercept(x1, y2, b);
        return rangeClosed(xMin, xMax)
                .mapToObj(x -> pixel(x, x * b + a))
                .reduce((pixel1, pixel2) -> pixel1 | pixel2)
                .orElse(0L);
    }

    private int slope(int x1, int y1, int x2, int y2) {
        return (y2 - y1) / (x2 - x1);
    }

    private int intercept(int x1, int y2, int b) {
        if (b == 0) { // horizontal
            return y2;
        }
        if (x1 == 0) { // horizontal at 0
            return 0;
        }
        return y2 / (b * x1);
    }

    private long pixel(int x, int y) {
        return 1L << (63 - x - (y * 8));
    }
}
