package io.github.adrianulbona.kata.cc_4_graphs_trees;

import lombok.Data;

import java.util.Optional;

import static java.util.Optional.empty;

@Data
public class Node {

    public static Node NIL;

    private final int value;
    private final Optional<Node> left;
    private final Optional<Node> right;


    public static Node node(int value, Optional<Node> left, Optional<Node> right) {
        return new Node(value, left, right);
    }

    public static Node node(int value, Node left, Node right) {
        return new Node(value, Optional.of(left), Optional.of(right));
    }

    public static Node node(int value) {
        return new Node(value, empty(), empty());
    }

    public boolean isLeaf() {
        return !(this.left.isPresent() || this.right.isPresent());
    }
}
