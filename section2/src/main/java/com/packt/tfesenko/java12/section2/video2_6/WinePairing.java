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

    private String getFoodPairingForWine(String wine) {
        String foodPairing;
        switch (wine) {
            case "Cabernet Sauvignon":
                foodPairing = "Lamb chops";
                break;
            case "Gewürztraminer":
                foodPairing = "Feta cheese";
                break;
            case "Riesling":
                foodPairing = "Feta cheese";
            case "Champagne":
                foodPairing = "Salty popcorn";
                break;
            default:
                foodPairing = "Fresh bread";
        }
        return foodPairing;
    }



}
