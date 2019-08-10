package io.github.adrianulbona.kata.cc_2_lists;

import java.util.function.Predicate;

public class _06_PalindromeChecker implements Predicate<Node> {

    @Override
    public boolean test(Node node) {
        return node.equals(node.reverse());
    }
}
