package io.github.adrianulbona.kata.cc_03_stacks_queues;

import io.github.adrianulbona.kata.cc_03_stacks_queues._06_Shelter.Pet;
import org.junit.jupiter.api.Test;

import static io.github.adrianulbona.kata.cc_03_stacks_queues._06_Shelter.Pet.Type.CAT;
import static io.github.adrianulbona.kata.cc_03_stacks_queues._06_Shelter.Pet.Type.DOG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _06_ShelterTest {

    @Test
    void testEmpty() {
        final _06_Shelter shelter = new _06_Shelter();
        assertTrue(shelter.dequeue(Pet.Type.CAT).isEmpty());
        assertTrue(shelter.dequeue(DOG).isEmpty());
    }

    @Test
    void testOnlyDogs() {
        final _06_Shelter shelter = new _06_Shelter();
        final Pet rex = Pet.dog("Rex");
        final Pet bobby = Pet.dog("Bobby");
        shelter.enqueue(rex);
        shelter.enqueue(bobby);
        assertEquals(rex, shelter.dequeue(DOG).orElseThrow());
        assertEquals(bobby, shelter.dequeue(DOG).orElseThrow());
    }

    @Test
    void testOnlyCats() {
        final _06_Shelter shelter = new _06_Shelter();
        final Pet kitty = Pet.cat("Kitty");
        final Pet jessy = Pet.cat("Jessy");
        shelter.enqueue(kitty);
        shelter.enqueue(jessy);
        assertEquals(kitty, shelter.dequeue(CAT).orElseThrow());
        assertEquals(jessy, shelter.dequeue(CAT).orElseThrow());
    }

    @Test
    void testEnqueueAny() {
        final _06_Shelter shelter = new _06_Shelter();
        final Pet kitty = Pet.cat("Kitty");
        final Pet jessy = Pet.cat("Jessy");
        final Pet rex = Pet.dog("Rex");
        final Pet bobby = Pet.dog("Bobby");
        shelter.enqueue(kitty);
        shelter.enqueue(jessy);
        shelter.enqueue(rex);
        shelter.enqueue(bobby);
        assertEquals(kitty, shelter.dequeue().orElseThrow());
        assertEquals(jessy, shelter.dequeue().orElseThrow());
        assertEquals(rex, shelter.dequeue().orElseThrow());
        assertEquals(bobby, shelter.dequeue().orElseThrow());
    }
}
