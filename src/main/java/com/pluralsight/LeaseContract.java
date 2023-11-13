package com.pluralsight;

import java.text.DecimalFormat;

public class LeaseContract extends Contract {
    double expectedEnding;
    double leaseFee;
    double monthlyPayment;
    public static DecimalFormat df = new DecimalFormat("0.00");

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double leaseExpected, double leaseFee, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEnding = expectedEnding;
        this.leaseFee = this.leaseFee;
        this.monthlyPayment = this.monthlyPayment;
    }

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEnding = expectedEnding;
        this.leaseFee = this.leaseFee;
        this.monthlyPayment = this.monthlyPayment;
    }

    public double getExpectedEnding() {
        return vehicleSold.getPrice() / 2;
    }

    public double getLeaseFee() {
        return vehicleSold.getPrice() * .07;
    }

    @Override
    public double getTotalPrice() {
        double tempTotal = vehicleSold.getPrice() / 2 + vehicleSold.getPrice() * .07;
        return tempTotal;
    }

    @Override
    public double getMonthlyPayment() {
        return getTotalPrice() * (0.04/12) / (1 - Math.pow(1 + (0.04 / 12), -36));

    }

    @Override
    public String toString() {
        String csv = date + "|" + customerName + "|" + customerEmail + "|" + vehicleSold.toString() + "|" + df.format(getExpectedEnding()) + "|" + df.format(getLeaseFee()) + "|" + df.format(getTotalPrice()) + "|" + df.format(getMonthlyPayment());
        return csv;

    }
}
