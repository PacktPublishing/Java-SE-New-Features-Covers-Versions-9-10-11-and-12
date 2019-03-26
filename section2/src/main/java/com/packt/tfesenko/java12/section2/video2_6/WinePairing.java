package com.packt.tfesenko.java12.section2.video2_6;

import java.util.List;
import java.util.Random;

public class WinePairing {

    private Random random = new Random();

    public static void main(String[] args) {
        WinePairing app = new WinePairing();
        System.out.println(app.getFoodPairingForWine("Gewürztraminer"));
        System.out.println(app.getFoodPairingForWine("Pinot Noir"));
    }
    
 // Install and enable Java 12 to run this code!!
    private String getFoodPairingForWine(String wine) {
    	return "Install and enable Java 12 to run this code!!";
//        return switch (wine) {
//            case "Cabernet Sauvignon" -> "Lamb chops";
//            case "Gewürztraminer", "Riesling" -> "Feta";
//            case "Champagne" -> "Salty popcorn";
//            default -> {
//                var defaultChoices = List.of("Fresh bread", "Crackers", "Coffee");
//                break defaultChoices.get(random.nextInt(defaultChoices.size()));
//            }
//        };
    }


}
