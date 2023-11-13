package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    public static Scanner myScanner = new Scanner(System.in);
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void Display() throws IOException {
        int userInput;

        do {
            System.out.println("""
                    Here are your options for dealerships!
                    """);
            for (int i = 0; i < Main.dealerships.size(); i++) {
                System.out.println((i + 1) + ") " + Main.dealerships.get(i).toString());

            }
            System.out.println("To exit enter -1");
            userInput = myScanner.nextInt();
            myScanner.nextLine();
            if (userInput >= 1 && userInput <= Main.dealerships.size()) {
                showDealership(Main.dealerships.get(userInput - 1));
            } else if (userInput == -1) {

            } else {
                System.out.println("Invalid option");
            }

        }
        while (userInput != -1);
        FileWriter fileWriter = new FileWriter("inventory.csv");
        fileWriter.write("");
        fileWriter.close();
        for(Dealership dealership : Main.dealerships){
            DealershipFileManager.saveDealership(dealership);
        }

    }

    public static void showDealership(Dealership dealerships) throws IOException {
        int userInput;

        do {
            System.out.println("""
                    Here are your options!
                    1) Find within a price range
                    2) Find by make/model
                    3) Find by year range
                    4) Find by color
                    5) Find by mileage range
                    6) Find by type (SUV,truck,van,car)
                    7) List all Vehicles
                    8) Add a vehicle
                    9) Remove a vehicle
                    10) Buy a vehicle
                    11) Lease a vehicle
                    99) Quit
                    """);
            userInput = myScanner.nextInt();
            myScanner.nextLine();
            switch (userInput) {
                case 1:
                    System.out.println("Enter the min range");
                    int min = myScanner.nextInt();
                    System.out.println("Enter the max range");
                    int max = myScanner.nextInt();
                    dealerships.getVehiclesByPrice(min, max);
                    break;
                case 2:
                    System.out.println("Enter the make of the car");
                    String make = myScanner.nextLine();
                    System.out.println("Enter the model of the car");
                    String model = myScanner.nextLine();
                    dealerships.getVehiclesByMake(make, model);
                    break;
                case 3:
                    System.out.println("Enter the min range");
                    int min1 = myScanner.nextInt();
                    System.out.println("Enter the max range");
                    int max1 = myScanner.nextInt();
                    dealerships.getVehiclesByYear(min1, max1);
                    break;
                case 4:
                    System.out.println("Enter the desired color");
                    String color = myScanner.nextLine();
                    dealerships.getVehiclesByColor(color);
                    break;
                case 5:
                    System.out.println("Enter the min range");
                    int min2 = myScanner.nextInt();
                    System.out.println("Enter the max range");
                    int max2 = myScanner.nextInt();
                    dealerships.getVehiclesByMileage(min2, max2);
                    break;
                case 6:
                    System.out.println("Enter the desired type");
                    String type = myScanner.nextLine();
                    dealerships.getVehiclesByType(type);
                    break;
                case 7:
                    dealerships.getAllVehicles();
                    break;
                case 8:
                    System.out.println("Vin");
                    int userVin = myScanner.nextInt();
                    System.out.println("Year");
                    int userYear = myScanner.nextInt();
                    System.out.println("Odometer");
                    int userOdometer = myScanner.nextInt();
                    myScanner.nextLine();
                    System.out.println("Make");
                    String userMake = myScanner.nextLine();
                    System.out.println("Model");
                    String userModel = myScanner.nextLine();
                    System.out.println("Type");
                    String userType = myScanner.nextLine();
                    System.out.println("Color");
                    String userColor = myScanner.nextLine();
                    System.out.println("Price");
                    double userPrice = myScanner.nextDouble();
                    dealerships.addVehicle(new Vehicle(userVin, userYear, userOdometer, userPrice, userMake, userModel, userType, userColor));
                    break;
                case 9:
                    for (int i = 0; i < dealerships.inventory.size(); i++) {
                        System.out.println((i + 1) + ") " + dealerships.inventory.get(i).toString());

                    }
                    System.out.println("Enter the the vehicle you want to remove");
                    int removeChoice = myScanner.nextInt();
                    if (removeChoice >= 1 && removeChoice <= dealerships.inventory.size()) {
                        dealerships.removeVehicle(dealerships.inventory.get(removeChoice -1));
                    } else {
                        System.out.println("Invalid option, returning to dealership screen!");
                    }
                    break;
                case 10:
                    boolean isFinanced;
                    String date,customerName,customerEmail,financeOption;
                    date = LocalDate.now().format(dateTimeFormatter);
                    System.out.println("Name");
                    customerName = myScanner.nextLine();
                    System.out.println("Email");
                    customerEmail = myScanner.nextLine();
                    System.out.println("Finance : Yes or No");
                    financeOption = myScanner.nextLine().toLowerCase();
                    if(financeOption.charAt(0) == 'y'){
                        isFinanced = true;
                    }else{
                        isFinanced = false;
                    }
                    for (int i = 0; i < dealerships.inventory.size(); i++) {
                        System.out.println((i + 1) + ") " + dealerships.inventory.get(i).toString());

                    }
                    System.out.println("Enter the the vehicle you want to purchase");
                    int purchaseChoice = myScanner.nextInt();
                    if (purchaseChoice >= 1 && purchaseChoice <= dealerships.inventory.size()) {
                        ContractFileManager.saveContract(new SalesContract(date,customerName,customerEmail,dealerships.inventory.get(purchaseChoice -1),isFinanced));
                        dealerships.removeVehicle(dealerships.inventory.get(purchaseChoice -1));
                    } else {
                        System.out.println("Invalid option, returning to dealership screen!");
                    }
                    break;
                case 11:
                    String date2,customerName2,customerEmail2;
                    date2 = LocalDate.now().format(dateTimeFormatter);
                    System.out.println("Name");
                    customerName2 = myScanner.nextLine();
                    System.out.println("Email");
                    customerEmail2 = myScanner.nextLine();
                    for (int i = 0; i < dealerships.inventory.size(); i++) {
                        System.out.println((i + 1) + ") " + dealerships.inventory.get(i).toString());

                    }
                    System.out.println("Enter the the vehicle you want to lease");
                    int leaseChoice = myScanner.nextInt();
                    if (leaseChoice >= 1 && leaseChoice <= dealerships.inventory.size()) {
                        ContractFileManager.saveContract(new LeaseContract(date2,customerName2,customerEmail2,dealerships.inventory.get(leaseChoice -1)));
                        dealerships.removeVehicle(dealerships.inventory.get(leaseChoice -1));
                    } else {
                        System.out.println("Invalid option, returning to dealership screen!");
                    }

                    break;
                case 99:
                    break;
                default:
                    System.out.println("Invalid input, please choose one of the following.");
                    break;
            }

        }
        while (userInput != 99);

    }
}
