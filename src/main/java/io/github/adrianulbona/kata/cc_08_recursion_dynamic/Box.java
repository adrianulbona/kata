package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import lombok.Data;

@Data
public class Box {

    private final int width;
    private final int height;
    private final int depth;

    public static Box of(int width, int height, int depth) {
        return new Box(width, height, depth);
    }

    boolean supports(Box box) {
        return this.depth > box.depth && this.height > box.height && this.width > box.width;
    }
}
