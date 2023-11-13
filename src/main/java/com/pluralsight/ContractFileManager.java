package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    public static void getContracts() throws IOException {
        String input;
        int vin, year, odometer, count = -1;
        boolean isFinanced;
        double price, leaseExpected, leaseFee, totalPrice, monthlyPayment, salesTax, processingFee,recordingFee;
        String make, model, vehicleType, color, name, email, date;
        ArrayList<Contract> contracts = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("contracts.csv"));
        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (transactionReader[0].contains("SALE")) {
                date = transactionReader[1];
                name = transactionReader[2];
                email = transactionReader[3];
                vin = Integer.parseInt(transactionReader[4]);
                year = Integer.parseInt(transactionReader[5]);
                make = transactionReader[6];
                model = transactionReader[7];
                vehicleType = transactionReader[8];
                color = transactionReader[9];
                odometer = Integer.parseInt(transactionReader[10]);
                price = Double.parseDouble(transactionReader[11]);
                salesTax = Double.parseDouble(transactionReader[12]);
                recordingFee = Double.parseDouble(transactionReader[13]);
                processingFee = Double.parseDouble(transactionReader[14]);
                totalPrice = Double.parseDouble(transactionReader[15]);
                if (transactionReader[16].equalsIgnoreCase("no")) {
                    isFinanced = false;
                } else {
                    isFinanced = true;
                }
                monthlyPayment = Double.parseDouble(transactionReader[17]);
                contracts.add(new SalesContract(date, name, email, new Vehicle(vin, year, odometer, price, make, model, vehicleType, color), salesTax, processingFee, totalPrice, isFinanced, monthlyPayment));
                count++;
            } else {
                date = transactionReader[1];
                name = transactionReader[2];
                email = transactionReader[3];
                vin = Integer.parseInt(transactionReader[4]);
                year = Integer.parseInt(transactionReader[5]);
                make = transactionReader[6];
                model = transactionReader[7];
                vehicleType = transactionReader[8];
                color = transactionReader[9];
                odometer = Integer.parseInt(transactionReader[10]);
                price = Double.parseDouble(transactionReader[11]);
                leaseExpected = Double.parseDouble(transactionReader[12]);
                leaseFee = Double.parseDouble(transactionReader[13]);
                totalPrice = Double.parseDouble(transactionReader[14]);
                monthlyPayment = Double.parseDouble(transactionReader[15]);

                contracts.add(new LeaseContract(date, name, email, new Vehicle(vin, year, odometer, price, make, model, vehicleType, color), leaseExpected, leaseFee, totalPrice, monthlyPayment));

            }
        }
        bufferedReader.close();


    }

    public static void saveContract(Contract contract) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));
        if(contract instanceof SalesContract){
            bufferedWriter.write("SALE|" + contract.toString());
        } else{
            bufferedWriter.write("LEASE|" + contract.toString());
        }
        bufferedWriter.newLine();
        bufferedWriter.close();


    }


}
