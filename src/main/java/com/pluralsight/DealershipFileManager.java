package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public static ArrayList<Dealership> getDealership() throws IOException {
        String input;
        int vin, year, odometer,count = -1;
        double price;
        String make, model, vehicleType, color;
        ArrayList<Dealership> dealership = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (transactionReader[0].contains("Dealership")) {
                dealership.add(new Dealership(transactionReader[0], transactionReader[1], transactionReader[2]));
                count++;
            } else {
                vin = Integer.parseInt(transactionReader[0]);
                year = Integer.parseInt(transactionReader[1]);
                make = transactionReader[2];
                model = transactionReader[3];
                vehicleType = transactionReader[4];
                color = transactionReader[5];
                odometer = Integer.parseInt(transactionReader[6]);
                price = Double.parseDouble(transactionReader[7]);

                dealership.get(count).inventory.add(new Vehicle(vin, year, odometer, price, make, model, vehicleType, color));

            }
        }
        bufferedReader.close();
        return dealership;
    }


    public static void saveDealership(Dealership dealership) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv",true));
        bufferedWriter.write(dealership.toString());
        for (Vehicle v : dealership.inventory) {
            bufferedWriter.newLine();
            bufferedWriter.write(v.toString());
        }
        bufferedWriter.newLine();
        bufferedWriter.close();

    }

}

