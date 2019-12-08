package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _01_PathCheckerTest {

    @Test
    void testEmpty() {
        final _01_PathChecker pathChecker = new _01_PathChecker(Collections.emptyMap());
        assertFalse(pathChecker.test(1, 2));
    }

    @Test
    void testNeighbours() {
        final Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(1, List.of(2));
            put(2, List.of(1));
        }};

        final _01_PathChecker pathChecker = new _01_PathChecker(graph);
        assertTrue(pathChecker.test(1, 2));
        assertTrue(pathChecker.test(2, 1));
    }

    @Test
    void testMultipleHops() {
        final Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(1, List.of(2));
            put(2, List.of(3, 4));
            put(3, List.of(5));
        }};

        final _01_PathChecker pathChecker = new _01_PathChecker(graph);
        assertTrue(pathChecker.test(1, 5));
    }

    @Test
    void testPathNotExisting() {
        final Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(1, List.of(2));
            put(2, List.of(3, 4));
            put(3, List.of(5));
        }};

        final _01_PathChecker pathChecker = new _01_PathChecker(graph);
        assertFalse(pathChecker.test(3, 1));
    }
}
