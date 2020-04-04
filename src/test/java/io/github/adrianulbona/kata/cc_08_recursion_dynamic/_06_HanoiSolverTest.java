package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _06_HanoiSolverTest {

    private _06_HanoiSolver solver;

    @BeforeEach
    void setUp() {
        this.solver = new _06_HanoiSolver();
    }

    @Test
    void move0() {
        final Stack<Integer> source = new Stack<>();
        final Stack<Integer> target = new Stack<>();
        final Stack<Integer> aux = new Stack<>();

        this.solver.move(0, source, target, aux);

        assertTrue(source.empty());
        assertTrue(target.empty());
        assertTrue(aux.empty());
    }

    @Test
    void move1() {
        final Stack<Integer> source = new Stack<>();
        source.push(1);
        final Stack<Integer> aux = new Stack<>();
        final Stack<Integer> target = new Stack<>();

        this.solver.move(1, source, target, aux);

        assertTrue(source.empty());
        assertTrue(aux.empty());
        assertEquals(1, target.size());
        assertEquals(1, target.peek());
    }

    @Test
    void move5() {
        final Stack<Integer> source = new Stack<>();
        source.push(5);
        source.push(4);
        source.push(3);
        source.push(2);
        source.push(1);

        final Stack<Integer> aux = new Stack<>();
        final Stack<Integer> target = new Stack<>();

        this.solver.move(5, source, target, aux);

        assertTrue(source.empty());
        assertTrue(aux.empty());
        assertEquals(5, target.size());
        assertEquals(1, target.pop());
        assertEquals(2, target.pop());
        assertEquals(3, target.pop());
        assertEquals(4, target.pop());
        assertEquals(5, target.pop());
    }
}
