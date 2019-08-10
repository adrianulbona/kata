package io.github.adrianulbona.kata.cc_2_lists;


import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_2_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_2_lists.Node.node;

public class _05_DigitAdder implements BiFunction<Node, Node, Node> {

    @Override
    public Node apply(Node x, Node y) {
        return applyWithCarry(x, y, 0);
    }

    private Node applyWithCarry(Node x, Node y, Integer carry) {
        if (NIL.equals(x) && NIL.equals(y)) {
            return carry == 0 ? NIL : node(carry);
        }
        final int sum = carry + x.valueOrElse(0) + y.valueOrElse(0);
        return node(sum % 10, applyWithCarry(x.nextOrElse(NIL), y.nextOrElse(NIL), sum / 10));
    }
}
