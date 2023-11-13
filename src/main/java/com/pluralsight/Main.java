package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Dealership> dealerships;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Car Dealership!");
        dealerships = DealershipFileManager.getDealership();
        UserInterface.Display();
    }


}
