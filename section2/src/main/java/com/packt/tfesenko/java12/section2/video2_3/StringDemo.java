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
    

        String maybeBlankString = "";
        maybeBlankString = "not blank";
        maybeBlankString = "      ";
        maybeBlankString = "\t    \t\u2003  ";
        System.out.println();
    }

    public void demoLinesAndRepeat() {
        System.out.println();
        System.out.println("Demo: String.repeat()");

        String str = " Eclair is a kind Bengal cat.\n Give her a coconut cake. Now!\r\nPlease...";
    }

    public void demoJava12() {
        System.out.println();
    }

    public static String fixCatDescription(String str) {
        return str.replaceAll("Eclair", "Jelly").replaceAll("fluffy Persian", "kind Bengal");
    }
}
