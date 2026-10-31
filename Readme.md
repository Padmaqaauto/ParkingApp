# 🚗 Parking Reservation System

A Java-based console application for managing parking spaces and vehicle reservations. This project demonstrates Java fundamentals, object relationships, encapsulation, collections, enums, date/time handling, and unit testing with JUnit 5.

## 📌 Project Overview

The Parking Reservation System allows users to register people and vehicles, view parking space availability, create reservations, and complete reservations when vehicles leave.

The application is developed as part of Java Fundamentals practice.

## ✨ Features

- **Person Registration** – Register people using their name and phone number.
- **Vehicle Registration** – Register vehicles and associate them with their owners.
- **Parking Space Management** – Display parking spaces and their availability.
- **Create Reservations** – Reserve an available parking space for a registered vehicle.
- **Reservation Duration** – Calculate the expected end time based on the selected duration.
- **Complete Reservations** – Complete active reservations and release parking spaces.
- **Reservation Tracking** – Maintain reservation details and statuses.

## 🛠️ Technologies Used

| Technology | Purpose |
|---         |---       |
| Java | Application development |
| IntelliJ IDEA | Development environment |
| JUnit 5 | Unit testing |
| Maven | Dependency and build management |
| Git & GitHub | Version control |

## 📂 Project Structure

```text
ParkingApp/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── se/lexicon/
│   │           ├── App.java
│   │           └── parking/
│   │               └── model/
│   │                   ├── Person.java
│   │                   ├── Vehicle.java
│   │                   ├── ParkingArea.java
│   │                   ├── ParkingSpace.java
│   │                   ├── Reservation.java
│   │                   ├── SpaceStatus.java
│   │                   └── ReservationStatus.java
│   └── test/
│       └── java/
│           └── se/lexicon/parking/model/
│               ├── PersonTest.java
│               ├── VehicleTest.java
│               ├── ParkingAreaTest.java
│               ├── ParkingSpaceTest.java
│               ├── ReservationTest.java
│               ├── SpaceStatusTest.java
│               └── ReservationStatusTest.java
├── pom.xml
└── README.md
```

## 🧠 Java Concepts Practiced

- Classes and objects
- Encapsulation
- Constructors and methods
- Object relationships and associations
- Arrays and ArrayList
- Enums
- Conditional statements and switch
- Loops
- Exception handling
- `LocalDateTime` and `Duration`
- UUID generation
- Unit testing with JUnit 5

## 🧪 Unit Testing

JUnit 5 is used to verify the behavior of the model classes.

Test coverage includes:

- Person creation and vehicle association
- Vehicle ownership and reservation collection
- Parking space creation and status management
- Parking area capacity and space lookup
- Reservation creation and expected end-time calculation
- Reservation completion and parking space availability
- Enum values

### Run Tests

Using Maven:

```bash
mvn clean test
```

Or run the test classes directly from IntelliJ IDEA.

## ▶️ How to Run the Application

1. Clone the repository:

```bash
git clone https://github.com/Padmaqaauto/ParkingApp.git
```

2. Open the project in IntelliJ IDEA.

3. Ensure the required JDK and Maven dependencies are configured.

4. Run `App.java`.

5. Follow the console menu to register people, register vehicles, display spaces, create reservations, and complete reservations.

## 📋 Application Menu

```text
===== PARKING RESERVATION MENU =====
1. Register person
2. Register vehicle
3. Display parking spaces
4. Create reservation
5. Complete reservation
6. Exit
Choose an option:
```

## 🚀 Future Improvements

- Add input validation and meaningful error messages.
- Prevent duplicate person and vehicle registrations.
- Prevent multiple active reservations for the same parking space.
- Add more unit tests for invalid inputs and edge cases.
- Introduce persistence to retain reservation data between application runs.

## 👩‍💻 Author

**Padmaqaauto**

GitHub: [https://github.com/Padmaqaauto](https://github.com/Padmaqaauto)

---

*This project is part of my ongoing Java learning journey, focusing on building practical applications using core Java concepts and test-driven development practices.*