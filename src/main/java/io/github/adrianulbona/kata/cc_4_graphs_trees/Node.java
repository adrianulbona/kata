package io.github.adrianulbona.kata.cc_4_graphs_trees;

import lombok.Data;

@Data
public class Node {

    public static final Node NIL = new Node(Integer.MIN_VALUE, null, null);

    private final int value;
    private final Node left;
    private final Node right;


    public static Node node(int value, Node left, Node right) {
        return new Node(value, left, right);
    }

    public static Node node(int value) {
        return new Node(value, NIL, NIL);
    }
}
