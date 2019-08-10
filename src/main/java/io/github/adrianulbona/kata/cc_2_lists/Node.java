package io.github.adrianulbona.kata.cc_2_lists;

import lombok.Data;

import java.util.function.Predicate;

@Data
class Node {

    public static Node NIL = node(-1, null);

    private final int value;
    private final Node next;

    static Node node(int data, Node next) {
        return new Node(data, next);
    }

    Node removeAll(int value) {
        if (NIL.equals(this)) {
            return this;
        }
        if (this.value == value) {
            return this.next.removeAll(value);
        }
        return node(this.value, this.next.removeAll(value));
    }

    Node filter(Predicate<Node> predicate) {
        if (NIL.equals(this)) {
            return this;
        }
        if (predicate.test(this)) {
            return node(this.value, this.next.filter(predicate));
        }
        return this.next.filter(predicate);
    }

    Node get(int index) {
        if (NIL.equals(this)) {
            return NIL;
        }
        if (index == 0) {
            return this;
        }
        return this.next.get(index - 1);
    }

    int size() {
        if (NIL.equals(this)) {
            return 0;
        }
        return this.next.size() + 1;
    }

    Node append(Node other) {
        if (NIL.equals(this)) {
            return other;
        }
        return node(this.value, this.next.append(other));
    }
}
