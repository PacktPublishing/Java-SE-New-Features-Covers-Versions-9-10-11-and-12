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

    }

    public static void demoList() {
        // pre-Java 9 list
        var preJava9Dogs = Arrays.asList("Caesar", "Snoopy", "Brody");
        // preJava9Dogs.add("Cherry"); fails at runtime
        preJava9Dogs.set(1, "Snoopy Dog");
        System.out.println(preJava9Dogs);

    }

}
