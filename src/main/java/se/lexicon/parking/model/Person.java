package se.lexicon.parking.model;

import java.util.ArrayList;

public class Person {

    private String name;
    private String phoneNumber;

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    //constructor
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Display details

    public void displayPersonDetails(){
        IO.println("Name: " + name);
        IO.println("Phone Number: " + phoneNumber);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }



}
