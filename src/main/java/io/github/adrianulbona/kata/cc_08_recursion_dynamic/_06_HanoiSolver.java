package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.Stack;

class _06_HanoiSolver {

    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux) {
        if (n > 0) {
            move(n - 1, source, aux, target);
            target.push(source.pop());
            move(n - 1, aux, target, source);
        }
    }
}
