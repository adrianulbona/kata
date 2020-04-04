package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

record Box(int width, int height, int depth) {

    public static Box of(int width, int height, int depth) {
        return new Box(width, height, depth);
    }

    boolean supports(Box box) {
        return this.depth > box.depth && this.height > box.height && this.width > box.width;
    }
}
