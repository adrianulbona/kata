package io.github.adrianulbona.kata.cc_03_stacks_queues;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

class _06_Shelter {

    private final LinkedList<RegisteredPet> cats = new LinkedList<>();
    private final LinkedList<RegisteredPet> dogs = new LinkedList<>();

    private final AtomicInteger nextRegisterId = new AtomicInteger(0);

    void enqueue(Pet pet) {
        switch (pet.type) {
            case CAT -> this.cats.push(new RegisteredPet(pet, nextRegisterId.getAndIncrement()));
            case DOG -> this.dogs.push(new RegisteredPet(pet, nextRegisterId.getAndIncrement()));
        }
    }

    Optional<Pet> dequeue() {
        if (this.cats.isEmpty() && this.dogs.isEmpty()) {
            return Optional.empty();
        }

        if (this.cats.isEmpty()) {
            return pollDog();
        }

        if (this.dogs.isEmpty()) {
            return pollCat();
        }

        if (this.cats.peekLast().registerId < this.dogs.peekLast().registerId) {
            return pollCat();
        }
        return pollDog();
    }

    private Optional<Pet> pollDog() {
        return Optional.ofNullable(this.dogs.pollLast()).map(RegisteredPet::pet);
    }

    private Optional<Pet> pollCat() {
        return Optional.ofNullable(this.cats.pollLast()).map(RegisteredPet::pet);
    }

    Optional<Pet> dequeue(Pet.Type type) {
        return switch (type) {
            case CAT -> pollCat();
            case DOG -> pollDog();
        };
    }

    private record RegisteredPet(Pet pet, int registerId) {
    }

    public record Pet(Type type, String name) {

        static Pet cat(String name) {
            return new Pet(Pet.Type.CAT, name);
        }

        static Pet dog(String name) {
            return new Pet(Pet.Type.DOG, name);
        }

        public enum Type {
            CAT, DOG
        }
    }
}
