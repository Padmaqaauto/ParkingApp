package se.lexicon;

import se.lexicon.parking.model.ParkingArea;
import se.lexicon.parking.model.Person;
import se.lexicon.parking.model.Reservation;
import se.lexicon.parking.model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

    ArrayList<Person> people = new ArrayList<>();
    ParkingArea parkingArea = new ParkingArea("Main Parking Area", 20);

    void main(){

        Scanner input = new Scanner(System.in);
        int choice;

        do{
            IO.println("\n===== PARKING RESERVATION MENU =====");
            IO.println("\n1. Register person");
            IO.println("2. Register vehicle");
            IO.println("3. Display parking spaces");
            IO.println("4. Create reservation");
            IO.println("5. Complete reservation");
            IO.println("6. Exit");

            IO.println("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    IO.println("---Register person---");
                    registerPerson(input, people);
                    break;
                case 2:
                    IO.println("---Register vehicle---");
                    registerVehicle(input, people);
                    break;
                case 3:
                    IO.println("---Display parking spaces---");
                    parkingArea.displaySpaces();
                    break;
                case 4:
                    IO.println("---Create reservation---");
                    registerReservation(input, people, parkingArea);
                    break;
                case 5:
                    IO.println("---Complete reservation---");
                    completeReservation(input, people);
                    break;
                case 6:
                    IO.println("---Exiting application---");
                    break;
                default:
                    IO.println("Invalid choice.");
            }
        }while (choice != 6);

        input.close();
    }

    void registerPerson(Scanner input,ArrayList<Person> people){

        IO.println("Enter First Name: ");
        String firstName = input.nextLine();

        IO.println("Enter Phone Number: ");
        String phoneNumber = input.nextLine();

        Person person = new Person(firstName,phoneNumber);

        people.add(person);

        IO.println("Person successfully registered!");
        person.displayPersonDetails();

    }

    void registerVehicle(Scanner input, ArrayList<Person> people) {

        IO.print("Enter owner's phone number: ");
        String phoneNumber = input.nextLine();

        Person owner = null;

        for (Person person : people) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                owner = person;
                break;
            }
        }

        if (owner == null) {
            IO.println("Person not found. Please register the person first.");
            return;
        }

        IO.print("Enter vehicle registration number: ");
        String registrationNumber = input.nextLine();

        Vehicle vehicle = new Vehicle(registrationNumber, owner);

        owner.addVehicle(vehicle);

        IO.println("Vehicle registered successfully!");
        vehicle.displayVehicleDetails();
    }

    void registerReservation(
            Scanner input,
            ArrayList<Person> people,
            ParkingArea parkingArea
    ) {

        //Find Person
        IO.println("Enter owner's phone number: ");
        String phoneNumber = input.nextLine();

        Person owner = null;
        for (Person person : people) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                owner = person;
                break;
            }
        }

        if (owner == null) {
            IO.println("Person not found. Please register the person first.");
            return;
        }

        //Find Vehicle
        IO.println("Enter vehicle registration number: ");
        String registrationNumber = input.nextLine();

        Vehicle vehicle =null;

        for (Vehicle v : owner.getVehicles()) {
            if (v.getRegistrationNumber().equals(registrationNumber)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            IO.println("Vehicle not found for this person.");
            return;
        }

        //Find Parking Space

        IO.println("Enter Parking Space Id: ");
        String parkingSpaceId = input.nextLine();

        var parkingSpace = parkingArea.getSpaceById(parkingSpaceId);

        if (parkingSpace == null) {
            IO.println("Parking Space not found for this person.");
            return;
        }

        // Get Duration
        IO.println("Enter parking duration in hours: ");
        int durationHours = input.nextInt();
        input.nextLine();

        if(durationHours <= 0){
            IO.println("Duration must be greater than 0.");
            return;
        }

        // Create Reservation
        LocalDateTime startTime = LocalDateTime.now();
        Duration duration = Duration.ofHours(durationHours);

        Reservation reservation = new Reservation(
                owner,
                vehicle,
                parkingSpace,
                startTime,
                duration
        );

        //Establish Object Relationships
        owner.addReservation(reservation);
        vehicle.addReservation(reservation);
        parkingSpace.addReservation(reservation);

        //update parking space
        parkingSpace.setStatus(SpaceStatus.OCCUPIED);

        // Display confirmation
        IO.println("\nReservation created successfully!");
        IO.println("Reservation ID: " + reservation.getReservationID());
        IO.println("Person: " + owner.getName());
        IO.println("Vehicle: " + vehicle.getRegistrationNumber());
        IO.println("Parking Space: " + parkingSpace.getSpaceId());
        IO.println("Start Time: " + reservation.getStartTime());
        IO.println("Expected End Time: " + reservation.getExpectedEndTime());
        IO.println("Status: " + reservation.getStatus());
    }


    void completeReservation(
            Scanner scanner,
            ArrayList<Person> people) {

        IO.println("\n--- COMPLETE RESERVATION ---");

        IO.print("Enter reservation ID: ");
        String reservationId = scanner.nextLine();

        Reservation foundReservation = null;

        for (Person person : people) {

            for (Reservation reservation : person.getReservations()) {

                if (reservation.getReservationID()
                        .toString().equalsIgnoreCase(reservationId)) {

                    foundReservation = reservation;
                    break;
                }
            }

            if (foundReservation != null) {
                break;
            }
        }

        if (foundReservation == null) {
            IO.println("Reservation not found.");
            return;
        }

        if (foundReservation.getStatus() == ReservationStatus.COMPLETED) {
            IO.println("Reservation is already completed.");
            return;
        }

        foundReservation.complete();

        IO.println("Reservation completed successfully!");
        IO.println("Actual End Time: " + foundReservation.getActualEndTime());
        IO.println("Parking Space: " +
                foundReservation.getParkingSpace().getSpaceId());
        IO.println("Status: " + foundReservation.getStatus());
    }
}
