package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    public void getDealership() throws IOException {
        String input;
        int vin, year, odometer;
        double price;
        String make, model, vehicleType, color;
        Dealership dealership = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (transactionReader[0].contains("D")) {
                dealership = new Dealership(transactionReader[0], transactionReader[1], transactionReader[2]);

            } else {
                vin = Integer.parseInt(transactionReader[0]);
                year = Integer.parseInt(transactionReader[1]);
                make = transactionReader[2];
                model = transactionReader[3];
                vehicleType = transactionReader[4];
                color = transactionReader[5];
                odometer = Integer.parseInt(transactionReader[6]);
                price = Double.parseDouble(transactionReader[7]);

                dealership.inventory.add(new Vehicle(vin, year, odometer, price, make, model, vehicleType, color));
            }
        }
        bufferedReader.close();
    }

    public void saveDealership(Dealership dealership) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv"));
        bufferedWriter.write(dealership.toString());
        for (Vehicle v : dealership.inventory) {
        }

    }

}

