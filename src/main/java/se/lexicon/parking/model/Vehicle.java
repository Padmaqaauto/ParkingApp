package se.lexicon.parking.model;

import java.util.ArrayList;

public class Vehicle {

    private String registrationNumber;
    private Person vehicleOwner;

    private ArrayList<Reservation> reservations = new ArrayList<>();

    //Constructor

    public Vehicle(String registrationNumber, Person vehicleOwner) {
        this.registrationNumber = registrationNumber;
        this.vehicleOwner = vehicleOwner;
    }

    //Getters

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Person getVehicleOwner() {
        return vehicleOwner;
    }

    //Setters

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleOwner(Person vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public void displayVehicleDetails() {
        IO.println("Registration Number: " + registrationNumber);
        IO.println("Vehicle Owner Name: " + vehicleOwner.getName());
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }
}
