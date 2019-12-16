package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _11_RandomChildSamplerTest {

    @Test
    void sample15nodes100000times() {
        final Function<Node, Node> sampler = new _11_RandomChildSampler(new Random(0)::nextInt);

        final Node tree = node(9,
                node(5,
                        node(3, node(2), node(4)),
                        node(7, node(6), node(8))),
                node(13,
                        node(11, node(10), node(12)),
                        node(15, node(14), node(16))));

        range(0, 1_500_000) // 15 nodes x 100 000
                .mapToObj(__ -> sampler.apply(tree).value())
                .collect(groupingBy(identity(), counting()))
                .forEach((__, count) -> {
                    System.out.println(count);
                    assertTrue(Math.abs(count - 100_000) < 1_000); // < 0.1%
                });
    }
}
