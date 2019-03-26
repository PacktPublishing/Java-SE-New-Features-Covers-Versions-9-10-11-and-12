package com.packt.tfesenko.java12.section2.video2_4;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class OptionalDemo {

    private final Cat fifie = new Cat("Fifie", "Sleeps on the heater in winter");

    private final List<Cat> cats = List.of(
            new Cat("Ella", "Loves height, but doesn't like jumping"),
            new Cat("Jelly", "Steals croissants, but doesn't eat them, just to play with them"),
            new Cat("Eclair", "Super lazy, sleeps 23 hours a day"),
            fifie);


    public static void main(String[] args) {
        var app = new OptionalDemo();
        app.demoIfPresentOrElse();
        app.demoOr();
        app.demoStream();
        app.demoIfEmpty();
        app.demoOrElseThrow();
        app.demoNotPredicate();
    }

    public void demoOr() {
        System.out.println("\n\nOptional.or():");
        var cat = findCatByFunFact("croissant")
                .or(() -> getMyFavoriteCat());
        System.out.println(cat);
    }

    public void demoIfPresentOrElse() {
        System.out.println("\n\nOptional.ifPresentOrElse():");
        findCatByFunFact("croissant")
                .ifPresentOrElse(cat -> System.out.println(cat),
                        () -> System.out.println("No cat found"));
    }

    public void demoOrElseThrow() {
        System.out.println("\n\nOptional.orElseThrow():");
        findCatByFunFact("croissant")
                .orElseThrow();
        //.orElseThrow(IllegalStateException::new);
    }

    public void demoStream() {
        System.out.println("\n\nOptional.stream():");
        var catsForDescriptions = Stream.of("coconut cake", "croissant", "jump")
                .map(desc -> findCatByFunFact(desc))
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        System.out.println(catsForDescriptions);
    }

    public void demoIfEmpty() {
        System.out.println("\n\nOptional.isEmpty():");
        if (findCatByFunFact("cake").isEmpty()) {
            System.out.println("No meow this time, try again later");
        }
    }

    public void demoNotPredicate() {
        System.out.println("\n\nPredicate.not():");
        var catsThatAreNotElla = cats.stream()
                // pre-Java 11: .filter(hasName("Ella").negate())
                .filter(not(hasName("Ella")))
                .collect(Collectors.toList());
        System.out.println(catsThatAreNotElla);
    }


    public Optional<Cat> findCatByFunFact(String description) {
        return cats.stream()
                .filter(cat -> cat.funFact.contains(description)).findFirst();
    }

    public Optional<Cat> getMyFavoriteCat() {
        return Optional.of(fifie);
    }

    public Optional<String> getRandomFactAboutCats() {
        return Optional.of("Can jump as much as 7 times its height");
    }

    public static class Cat {
        private final String name;
        private final String funFact;

        public Cat(String name, String funFact) {
            this.name = name;
            this.funFact = funFact;
        }

        public String getName() {
            return name;
        }

        public String getFunFact() {
            return funFact;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return Objects.equals(name, cat.name) &&
                    Objects.equals(funFact, cat.funFact);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, funFact);
        }

        @Override
        public String toString() {
            return "\uD83D\uDC08 " + name + '\'' +
                    ": " + funFact + '\n';
        }

    }

    public static Predicate<Cat> hasName(String name) {
        return cat -> cat.name.equals(name);
    }

}
