package io.github.adrianulbona.kata.cc_04_graphs_trees;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

record Node(AtomicReference<Node> parentRef, Integer value, Node left, Node right, Integer size) {

    public static final Node NIL = new Node(null,null, null, null, 0);

    public Node parent() {
        return parentRef.get();
    }

    public void parent(Node parent) {
        this.parentRef.set(parent);
    }

    public static Node node(int value, Node left, Node right) {
        final Node node = new Node(new AtomicReference<>(NIL), value, left, right, 1 + left.size + right.size);
        if (!NIL.equals(left)) {
            left.parent(node);
        }
        if (!NIL.equals(right)) {
            right.parent(node);
        }
        return node;
    }

    public static Node node(int value) {
        return new Node(new AtomicReference<>(NIL), value, NIL, NIL, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Node node = (Node) o;
        return Objects.equals(value, node.value) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right) &&
                Objects.equals(size, node.size);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                ", size=" + size +
                '}';
    }
}
