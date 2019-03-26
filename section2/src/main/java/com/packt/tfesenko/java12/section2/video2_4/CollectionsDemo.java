package com.packt.tfesenko.java12.section2.video2_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsDemo {

    public static void main(String[] args) {
        demoList();
        demoMap();
    }

    public static void demoMap() {
        // pre-Java 9. These maps are modifiable
        Map<String, String> dogs1 = new HashMap<>();
        dogs1.put("Caesar", "Likes swimming");
        dogs1.put("Snoopy", "Likes jumping");

        Map<String, String> dogs2 = new HashMap<>() {
            {
                put("Caesar", "Likes swimming");
                put("Snoopy", "Likes jumping");
            }
        };

        // Java 9: unmodifiable Map.of()
        var dogs3 = Map.of(
                "Caesar", "Likes swimming",
                "Snoopy", "Likes jumping");

        // dogs3.put("foo", "bar"); // fails at runtime

        // Java 9: Map.ofEntries + Map.entry
        var dogs4 = Map.ofEntries(Map.entry("Jelly", "Likes to eat coconut cakes"));

        // Java 10: unmodifiable map for an existing map
        var dogs5 = Map.copyOf(dogs1);
    }

    public static void demoList() {
        // pre-Java 9 list
        var preJava9Dogs = Arrays.asList("Caesar", "Snoopy", "Brody");
        // preJava9Dogs.add("Cherry"); fails at runtime
        preJava9Dogs.set(1, "Snoopy Dog");
        System.out.println(preJava9Dogs);

        // Java 9
        var java9dogs = List.of("Caesar", "Snoopy", "Brody");
        // java9dogs.add("Cherry"); // fails at runtime
        // java9dogs.set(1, "Snoopy Dog"); // fails at runtime
        System.out.println(java9dogs);

        // Java 10
        var copyOfList = List.copyOf(preJava9Dogs);
        // copyOfList.add("Cherry"); // fails at runtime
        // copyOfList.set(1, "Snoopy Dog"); // fails at runtime
        preJava9Dogs.set(1, "Snoooooooopy");
        System.out.println(preJava9Dogs);
        System.out.println(copyOfList);
    }

}
