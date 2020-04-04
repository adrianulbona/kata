package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

class _13_BoxStacker implements Function<List<Box>, Integer> {

    @Override
    public Integer apply(List<Box> boxes) {
        if (boxes.size()  == 0) {
            return 0;
        }

        return boxes.stream()
                .mapToInt(extractedBox -> extractedBox.height() + apply(supportedBoxes(boxes, extractedBox)))
                .max()
                .orElse(0);
    }

    private List<Box> supportedBoxes(List<Box> boxes, Box extractedBox) {
        return boxes.stream().filter(extractedBox::supports).collect(toList());
    }
}
