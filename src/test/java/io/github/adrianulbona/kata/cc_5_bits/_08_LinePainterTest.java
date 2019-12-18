package io.github.adrianulbona.kata.cc_5_bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _08_LinePainterTest {

    @Test
    void applyDiagonal() {
        final _08_LinePainter painter = new _08_LinePainter();

        final long expected = 0b10000000_01000000_00100000_00010000_00001000_00000100_00000010_00000001L;
        final long actual = painter.apply(0, 0, 7, 7);
        assertEquals(expected, actual);
    }

    @Test
    void applyTheOtherDiagonal() {
        final _08_LinePainter painter = new _08_LinePainter();

        final long expected = 0b00000001_00000010_00000100_00001000_00010000_00100000_01000000_10000000L;
        final long actual = painter.apply(7, 0, 0, 7);
        assertEquals(expected, actual);
    }
    @Test
    void applySecondHorizontalLine() {
        final _08_LinePainter painter = new _08_LinePainter();

        final long expected = 0b00000000_11111111_00000000_00000000_00000000_00000000_00000000_00000000L;
        final long actual = painter.apply(0, 1, 7, 1);
        assertEquals(expected, actual);
    }
}