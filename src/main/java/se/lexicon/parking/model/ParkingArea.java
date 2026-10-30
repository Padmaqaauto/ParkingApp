package se.lexicon.parking.model;

public class ParkingArea {

    private String name;
    private ParkingSpace[] spaces;
    private int capacity;

    // Constructor
    public ParkingArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spaces = new ParkingSpace[capacity];

        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = new ParkingSpace("P" + (i + 1));
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public ParkingSpace[] getSpaces() {
        return spaces;
    }

    public void displaySpaces(){

        IO.println("\n---Parking Space Availability---");

        for (ParkingSpace space : spaces) {
            IO.println(
                    "Space ID: " + space.getSpaceId()
                    + " | Status : " + space.getStatus()
            );
        }
    }

    public ParkingSpace getSpaceById(String spaceId) {

        for (ParkingSpace space : spaces) {

            if (space.getSpaceId().equals(spaceId)) {
                return space;
            }
        }
        return null;
    }
}
