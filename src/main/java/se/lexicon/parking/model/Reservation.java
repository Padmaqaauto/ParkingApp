package se.lexicon.parking.model;

import se.lexicon.ReservationStatus;
import se.lexicon.SpaceStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {

    private UUID reservationId;
    private Person person;
    private Vehicle vehicle;
    private ParkingSpace parkingSpace;
    private LocalDateTime startTime;
    private LocalDateTime actualEndTime;
    private Duration plannedDuration;
    private LocalDateTime expectedEndTime;
    private ReservationStatus status;

    //Constructors
    public Reservation(
                       Person person,
                       Vehicle vehicle,
                       ParkingSpace parkingSpace,
                       LocalDateTime startTime,
                       Duration duration) {
        this.reservationId = UUID.randomUUID();
        this.person = person;
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        this.startTime = startTime;
        this.plannedDuration = duration;
        this.expectedEndTime = startTime.plus(this.plannedDuration);
        this.status = ReservationStatus.ACTIVE;
        this.actualEndTime = null;
    }

    //Getters
    public UUID getReservationID() {
        return reservationId;
    }

    public Person getPerson() {
        return person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getExpectedEndTime() {
        return expectedEndTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public Duration getPlannedDuration() {
        return plannedDuration;
    }

    public LocalDateTime getActualEndTime() {
        return actualEndTime;
    }


    public void complete() {

        this.actualEndTime = LocalDateTime.now();
        this.status = ReservationStatus.COMPLETED;

        parkingSpace.setStatus(SpaceStatus.AVAILABLE);
    }
}
