package io.github.adrianulbona.kata.cc_02_lists;

import java.util.function.BiPredicate;

class _07_IntersectionChecker implements BiPredicate<Node, Node> {

    @Override
    public boolean test(Node first, Node second) {
        if (Node.NIL.equals(first) || Node.NIL.equals(second)) {
            return false;
        }
        if (first == second) {
            return true;
        }
        return test(first.next(), second) || test(first, second.next());
    }
}
