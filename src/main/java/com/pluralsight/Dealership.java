package com.pluralsight;

import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dealership {
    private String name, address, phone;
    public ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void getVehiclesByPrice(double min, double max) {
        Collections.sort(inventory, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void getVehiclesByMake(String make, String model) {
        Collections.sort(inventory, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getMake().compareTo(o2.getMake());
            }
        });
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
            }
        }
    }

    public void getVehiclesByYear(int min, int max) {
        Collections.sort(inventory, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return (int) (o1.getYear() - o2.getYear());
            }
        });
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                System.out.println(v);
            }
        }
    }

    public void getVehiclesByColor(String color) {
        Collections.sort(inventory, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                System.out.println(v);
            }
        }
    }

    public void getVehiclesByMileage(int min, int max) {
        Collections.sort(inventory, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return (int) (o1.getOdometer() - o2.getOdometer());
            }
        });
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                System.out.println(v);
            }
        }
    }

    public void getVehiclesByType(String vehicleType) {
        Collections.sort(inventory, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getVehicleType().compareTo(o2.getVehicleType());
            }
        });
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(v);
            }
        }
    }

    public void getAllVehicles() {
        for (Vehicle v : inventory) {
            System.out.println(v);

        }
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }

    public void removeVehicle(Vehicle v) {
        inventory.remove(v);
    }

    @Override
    public String toString() {
        return this.getName() + "|" + this.getAddress() + "|" + this.getPhone();
    }
}
