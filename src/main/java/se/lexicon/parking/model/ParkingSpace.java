package se.lexicon.parking.model;

import se.lexicon.SpaceStatus;
import java.util.ArrayList;

public class ParkingSpace {

        private String spaceId;
        private SpaceStatus status;

        private ArrayList<Reservation> reservations = new ArrayList<>();

        //Constructor
        public ParkingSpace(String spaceId) {
            this.spaceId = spaceId;
            this.status = SpaceStatus.AVAILABLE;
        }

        //Getters
        public String getSpaceId() {
            return spaceId;
        }

        public SpaceStatus getStatus() {
            return status;
        }

        //Setters

        public void setSpaceId(String spaceId) {
            this.spaceId = spaceId;
        }

        public void setStatus(SpaceStatus status) {
            this.status = status;
        }

        public void addReservation(Reservation reservation) {
            reservations.add(reservation);
        }

        public ArrayList<Reservation> getReservations() {
            return new ArrayList<>(reservations);
         }

}
