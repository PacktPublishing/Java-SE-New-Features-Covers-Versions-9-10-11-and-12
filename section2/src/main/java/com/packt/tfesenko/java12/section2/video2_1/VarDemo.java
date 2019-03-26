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

public class VarDemo {

    public static void main(String[] args) {
        demoVar();
        coolThingsWithVar();
        notCool();
    }

    public static void demoVar() {

        // Without var: String cat = "Jack";
        var cat = "Jack";

        // List<String> catNames = List.of("Ella", "Jelly", "Eclair", "Jack");
        var catNames = List.of("Ella", "Jelly", "Eclair", "Jack");


        // Map<String, List<String>> catsWithDescriptions = <...>
        var catsWithDescription = Map.of(//
                "Jack", List.of("Super-fluffy.", "Sleeps all day long."), //
                "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")//
        );

        // In a FOR loop
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // in a try-with-resources
        try (var lines = Files.lines(Paths.get("src/main/java/com/packt/tfesenko/java12/section2/video2_1/VarDemo.java"))) {
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }


        // cannot be use in method signature
        // cannot be used for a field

        // Orthogonal to final
        final var bestCatName = "Ella";
        var secondBestCatName = "Eclair";
        secondBestCatName = "Jelly";

        // These code snippets Will not compile:
        // secondBestCatName = 142; //  Change type
        //var smartVariableName; // No type => cannot infer type
        //var smartVariableName = null; // Null type => cannot infer type

        // var is not a keyword, it's a reserved type name. Therefore, you can (but shouldn't) use it as a variable name
        var var = "Eclair";
    }

    public static void coolThingsWithVar() {
        // With anonymous classes
        var ella = new Object() {
            String name = "Ella";
            String description = "Fluffy";
        };
        System.out.println(ella.name);

        var catsWithDescription = Map.of(//
                "Jack", List.of("Super-fluffy.", "Sleeps all day long."), //
                "Ella", List.of("Black Bombay cat.", "Playful, fast, and agile.")//
        );

        var catObjects = catsWithDescription.entrySet().stream()
                .map(cat -> new Object() {
                    String name = cat.getKey();
                    List<String> description = cat.getValue();
                }).collect(Collectors.toList());

        catObjects.forEach(cat -> System.out.println(cat.name + ": " + cat.description));

        // var in lambda parameters
        AddressOperation toSingleLine1 =
                (String line1, int aptNumber, int zip) -> line1 + ", apt. " + aptNumber + "  " + zip;

        AddressOperation toSingleLine2 =
                (line1, aptNumber, zip) -> line1 + ", apt. " + aptNumber + "  " + zip;

        // var in lambda parameters, since Java 11
        AddressOperation toSingleLine3 =
                (var line1, var aptNumber, var zip) -> line1 + ", apt. " + aptNumber + "  " + zip;

        AddressOperation toSingleLine4 =
                (var line1, @Nullable var aptNumber, @ZipCode var zip) -> line1 + ", apt. " + aptNumber + "  " + zip;

    }

    public static void notCool() {
        // non-descriptive variable names
        var x = List.of("Ella", "Jelly", "Eclair", "Jack");

        // Unexpected type: ArrayList<Object>
        var cats = new ArrayList<>();
        cats.add("Jelly");
        cats.add(true);
        cats.add(-1);
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
