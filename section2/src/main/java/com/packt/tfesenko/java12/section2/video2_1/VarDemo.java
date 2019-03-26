package com.packt.tfesenko.java12.section2.video2_1;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VarDemo {

    public static void main(String[] args) {
        demoVar();
        coolThingsWithVar();
        notCool();
    }

    public static void demoVar() {
        String cat = "Jack";

        List<String> catNames = List.of("Ella", "Jelly", "Eclair", "Jack");

        Map<String, List<String>> catsWithDescription = Map.of(//
                "Jack", List.of("Super-fluffy.", "Sleeps all day long."), //
                "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")//
        );

        // In a FOR loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // in a try-with-resources
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/com/packt/tfesenko/java12/section2/video2_1/VarDemo.java"))) {
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void coolThingsWithVar() {
        // With anonymous classes
        Object ella = new Object() {
            String name = "Ella";
            String description = "Fluffy";
        };
        // System.out.println(ella.name); // doesn't compile with Object, compiles with a var

        Map<String, List<String>> catsWithDescription = Map.of(//
                "Jack", List.of("Super-fluffy.", "Sleeps all day long."), //
                "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")//
        );

        List<Object> catObjects = catsWithDescription.entrySet().stream()
                .map(cat -> new Object() {
                    String name = cat.getKey();
                    List<String> description = cat.getValue();
                }).collect(Collectors.toList());

        // catObjects.forEach(cat -> System.out.println(cat.name + ": " + cat.description)); // doesn't compile with Object, compiles with var

        // var in lambda parameters
        AddressOperation toSingleLine1 =
                (String line1, int aptNumber, int zip) -> line1 + ", apt. " + aptNumber + "  " + zip;
    }

    public static void notCool() {
    }


    @Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ZipCode {
    }

    @Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Nullable {
    }

    @FunctionalInterface
    interface AddressOperation {
        String build(String line1, int aptNumber, int zip);
    }

}
