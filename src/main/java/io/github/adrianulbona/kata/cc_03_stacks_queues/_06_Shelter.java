package io.github.adrianulbona.kata.cc_03_stacks_queues;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
class _06_Shelter {

    private final LinkedList<RegisteredPet> cats = new LinkedList<>();
    private final LinkedList<RegisteredPet> dogs = new LinkedList<>();

    private AtomicInteger nextRegisterId = new AtomicInteger(0);

    void enqueue(Pet pet) {
        switch (pet.type) {
            case CAT:
                this.cats.push(new RegisteredPet(pet, nextRegisterId.getAndIncrement()));
                break;
            case DOG:
                this.dogs.push(new RegisteredPet(pet, nextRegisterId.getAndIncrement()));
                break;
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
        switch (type) {
            case CAT:
                return pollCat();
            case DOG:
                return pollDog();
        }
        return Optional.empty();
    }

    @Data
    private static class RegisteredPet {
        private final Pet pet;
        private final int registerId;
    }

    @Data
    public static class Pet {

        public final Type type;
        public final String name;

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
