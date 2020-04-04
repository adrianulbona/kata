package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _07_PermNoDupsGeneratorTest {

    private Function<String, Stream<String>> generator;

    @BeforeEach
    void setUp() {
        this.generator = new _07_PermNoDupsGenerator();
    }

    @Test
    void applyA() {
        assertEquals(Set.of("a"), this.generator.apply("a").collect(toSet()));
    }

    @Test
    void applyABC() {
        assertEquals(Set.of("abc", "acb", "bac", "bca", "cab", "cba"), this.generator.apply("abc").collect(toSet()));
    }
}
