package com.pluralsight;

import java.text.DecimalFormat;

public class SalesContract extends Contract {
    double salesTax = .05;
    double recordingFee = 100;
    double processingFee;
    boolean isFinanced;
    boolean isOver10k;
    double interestRate;
    public static DecimalFormat df = new DecimalFormat("0.00");


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double salesTax, double processingFee, double totalPrice, boolean isFinanced, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTax = this.salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = this.processingFee;
        this.isFinanced = isFinanced;
        this.isOver10k = isOver10k;
        this.interestRate = interestRate;
    }

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTax = this.salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = this.processingFee;
        this.isFinanced = isFinanced;
        this.isOver10k = isOver10k;
        this.interestRate = interestRate;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if(vehicleSold.getPrice() >= 10000){
            return 495;
        }else{
            return 295;
        }

    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public boolean isOver10k() {
        return isOver10k;
    }

    public void setOver10k(boolean over10k) {
        isOver10k = over10k;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getTotalPrice() {
        double tempTotal = vehicleSold.getPrice() * 1.5 + 100;
        if (vehicleSold.getPrice() >= 10000) {
            tempTotal += 495;
        } else {
            tempTotal += 295;
        }
        return tempTotal;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0;
        } else {
            if (vehicleSold.getPrice() >= 10000) {
                return getTotalPrice() * (0.0425/12) / (1 - Math.pow(1 + (0.0425 / 12), -48));

            } else {
                return getTotalPrice() * (0.0525/12) / (1 - Math.pow(1 + (0.0525 / 12), -24));

            }
        }

    }

    @Override
    public String toString() {
        String csv = date + "|" + customerName + "|" + customerEmail + "|" + vehicleSold.toString() + "|" + df.format(vehicleSold.getPrice() * salesTax) +
                "|" + df.format(recordingFee) + "|" + df.format(getProcessingFee()) + "|" + df.format(getTotalPrice()) + "|";
        if(isFinanced){
            csv += "YES" + "|" + df.format(getMonthlyPayment());
        }else {
            csv += "NO" + "|" + df.format(getMonthlyPayment());
        }
        return csv;
    }
}
