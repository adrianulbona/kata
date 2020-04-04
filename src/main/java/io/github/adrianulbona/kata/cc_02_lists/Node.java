package io.github.adrianulbona.kata.cc_02_lists;

import java.util.function.Predicate;

record Node(int value, Node next) {

    public static Node NIL = node(-1, null);

    static Node node(int value, Node next) {
        return new Node(value, next);
    }

    static Node node(int value) {
        return new Node(value, NIL);
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

    int valueOrElse(int orElse) {
        return NIL.equals(this) ? orElse : this.value;
    }

    Node nextOrElse(Node orElse) {
        return NIL.equals(this) ? orElse : this.next;

    }

    Node reverse() {
        if (NIL.equals(this)) {
            return NIL;
        }

        return this.next().reverse().append(node(this.value));
    }
}
