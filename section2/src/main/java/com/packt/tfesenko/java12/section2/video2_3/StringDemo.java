package com.packt.tfesenko.java12.section2.video2_3;

public class StringDemo {
    public static void main(String[] args) {
        var app = new StringDemo();
        app.demoOperationsWithWhitespaces();
        app.demoLinesAndRepeat();
        app.demoJava12();
    }

    public void demoOperationsWithWhitespaces() {
        System.out.println("Demo: operations with whitespaces in Java 11");

        String str = "       Eclair is a very fluffy Persian cat.            ";// the last character is '\u2003' (em space)
        System.out.printf("str: '%s'\n", str);
        System.out.printf("str.trim(): '%s'\n", str.trim());
        System.out.printf("str.strip(): '%s'\n", str.strip());
        System.out.printf("str.stripLeading(): '%s'\n", str.stripLeading());
        System.out.printf("str.stripTrailing(): '%s'\n", str.stripTrailing());


        String maybeBlankString = "";
        System.out.printf("'%s'.isBlank(): %b\n", maybeBlankString, maybeBlankString.isBlank());

        maybeBlankString = "not blank";
        System.out.printf("'%s'.isBlank(): %b\n", maybeBlankString, maybeBlankString.isBlank());

        maybeBlankString = "      ";
        System.out.printf("'%s'.isBlank(): %b\n", maybeBlankString, maybeBlankString.isBlank());

        maybeBlankString = "\t    \t\u2003  ";
        System.out.printf("'%s'.isBlank(): %b\n", maybeBlankString, maybeBlankString.isBlank());
        System.out.println();
    }

    public void demoLinesAndRepeat() {
        System.out.println();
        System.out.println("\uD83D\uDC08".repeat(40));
        System.out.println("Demo: String.repeat()");

        String str = " Eclair is a kind Bengal cat.\n Give her a coconut cake. Now!\r\nPlease...";
        str.lines()
                .map(String::strip)
                .map(line -> (line.contains("Please")) ? "\uD83D\uDE3B".repeat(5) + line : line)
                .forEach(line -> System.out.println(line));
        System.out.println();
    }

    // Install and enable Java 12 to run this code!!
    public void demoJava12() {
//        System.out.println();
//        System.out.println("Demo Java 12: String.indent()");
//        String str = "one\ntwo\nthree";
//        str.lines()
//                .forEach(line -> System.out.print(line.indent(7)));
//
//
//        System.out.println("Demo Java 12: String.transform()");
//        str = "Eclair is a very fluffy Persian cat.\n";
//        System.out.println(str.transform(StringDemo::fixCatDescription).repeat(3));
//        System.out.println();
    }

    public static String fixCatDescription(String str) {
        return str.replaceAll("Eclair", "Jelly").replaceAll("fluffy Persian", "kind Bengal");
    }
}
