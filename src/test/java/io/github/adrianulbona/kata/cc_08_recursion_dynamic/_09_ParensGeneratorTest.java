package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _09_ParensGeneratorTest {

    private Function<Integer, Stream<String>> generator;

    @BeforeEach
    void setUp() {
        this.generator = new _09_ParensGenerator();
    }

    @Test
    void apply0() {
        assertEquals(Set.of(""), this.generator.apply(0).collect(toSet()));
    }

    @Test
    void apply1() {
        assertEquals(Set.of("()"), this.generator.apply(1).collect(toSet()));
    }

    @Test
    void apply2() {
        assertEquals(Set.of("()()", "(())"), this.generator.apply(2).collect(toSet()));
    }


    @Test
    void apply3() {
        assertEquals(Set.of("()()()", "(()())", "()(())", "(())()", "((()))"), this.generator.apply(3).collect(toSet()));
    }
}
