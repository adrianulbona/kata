package io.github.adrianulbona.kata.cc_4_graphs_trees;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Node {

    public static final Node NIL = new Node(null, null, null, 0);

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Node parent = NIL;

    private final Integer value;
    private final Node left;
    private final Node right;
    private final Integer size;

    public static Node node(int value, Node left, Node right) {
        final Node node = new Node(value, left, right, 1 + left.size + right.size);
        if (!NIL.equals(left)) {
            left.parent(node);
        }
        if (!NIL.equals(right)) {
            right.parent(node);
        }
        return node;
    }

    public static Node node(int value) {
        return new Node(value, NIL, NIL, 1);
    }
}
