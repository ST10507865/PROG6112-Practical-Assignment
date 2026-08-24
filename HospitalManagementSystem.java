package com.mycompany.hospitalmanagementsystem;

import java.util.Scanner;
import java.util.ArrayList;

class Patient {
    // Variables to store patient information
    private String patientID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private String patientCategory; // Inpatient, Outpatient, or Emergency

    // Constructor - special method that runs when we create a new Patient
    public Patient(String patientID, String firstName, String lastName,
                   int age, String gender, String medicalCondition,
                   String patientCategory) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.patientCategory = patientCategory;
    }

    // "Getter" methods - allow us to READ private variables
    public String getPatientID() { return patientID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getMedicalCondition() { return medicalCondition; }
    public String getPatientCategory() { return patientCategory; }

    // "Setter" methods - allow us to CHANGE/UPDATE private variables
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setMedicalCondition(String medicalCondition) { this.medicalCondition = medicalCondition; }
    public void setPatientCategory(String patientCategory) { this.patientCategory = patientCategory; }

    // Method to display all patient details neatly
    public void displayPatient() {
        System.out.println("----------------------------------------");
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Medical Condition: " + medicalCondition);
        System.out.println("Category: " + patientCategory);
        System.out.println("----------------------------------------");
    }
}

// ===================================================================
// YOUTUBE REFERENCE: Java While / Do-While Loops (Menu System)
// https://www.youtube.com/watch?v=ZjHJrmYknrk
// ===================================================================

// ===================================================================
// YOUTUBE REFERENCE: Java Switch Statements
// https://www.youtube.com/watch?v=B7AEJvEhmXo
// ===================================================================

// ===================================================================
// YOUTUBE REFERENCE: Java 2D Arrays (Rows & Columns)
// https://www.youtube.com/watch?v=qwgFU7HO8C8
// ===================================================================

public class HospitalManagementSystem {

    // ArrayList acts like a flexible container that holds Patient objects
    static ArrayList<Patient> patientList = new ArrayList<Patient>();

    // Scanner reads what the user types on the keyboard
    static Scanner input = new Scanner(System.in);

    // ===================================================================
    // BED MANAGEMENT: 20 beds arranged in a 4 x 5 layout
    // We use a 2D array: 4 rows, 5 columns
    // Each cell stores the Patient ID (String) if occupied,
    // or stays as null if the bed is AVAILABLE.
    // ===================================================================
    static String[][] bedOccupants = new String[4][5];

    public static void main(String[] args) {
        int choice = 0;

        // do-while loop: show the menu at least once, then repeat until user picks 11
        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("----- PATIENT MANAGEMENT -----");
            System.out.println("1. Register a New Patient");
            System.out.println("2. Search for a Patient by ID");
            System.out.println("3. Update Patient Details");
            System.out.println("4. Delete a Patient");
            System.out.println("5. Display All Patients");
            System.out.println("----- BED MANAGEMENT -----");
            System.out.println("6. Allocate a Bed to an Inpatient");
            System.out.println("7. Release a Bed");
            System.out.println("8. Display Complete Ward Layout");
            System.out.println("9. Display Available Beds");
            System.out.println("10. Display Occupied Beds");
            System.out.println("11. Exit");
            System.out.print("Enter your choice (1-11): ");

            choice = input.nextInt();
            input.nextLine(); // IMPORTANT: clears the Enter key from the buffer

            // switch checks which number the user typed
            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    searchPatient();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    displayAllPatients();
                    break;
                case 6:
                    allocateBed();
                    break;
                case 7:
                    releaseBed();
                    break;
                case 8:
                    displayWardLayout();
                    break;
                case 9:
                    displayAvailableBeds();
                    break;
                case 10:
                    displayOccupiedBeds();
                    break;
                case 11:
                    System.out.println("Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please type 1 to 11 only.");
            }

        } while (choice != 11); // keep looping as long as choice is not 11

        input.close(); // good practice: close the scanner when finished
    }

    // ===================================================================
    // HELPER METHOD: Find a patient by their ID and return the Patient object
    // Returns null if no patient is found.
    // ===================================================================
    public static Patient findPatientByID(String id) {
        for (int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);
            if (p.getPatientID().equals(id)) {
                return p;
            }
        }
        return null; // null means "not found"
    }

    // ===================================================================
    // HELPER METHOD: Convert row and column into a bed name like B01, B02, B20
    // Row 0, Col 0  -> Bed 1  -> B01
    // Row 0, Col 4  -> Bed 5  -> B05
    // Row 3, Col 4  -> Bed 20 -> B20
    // ===================================================================
    public static String getBedName(int row, int col) {
        int bedNumber = (row * 5) + col + 1;
        if (bedNumber < 10) {
            return "B0" + bedNumber;
        } else {
            return "B" + bedNumber;
        }
    }

    // ===================================================================
    // METHOD 1: Register a new patient
    // ===================================================================
    public static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");

        System.out.print("Enter Patient ID: ");
        String id = input.nextLine();

        // Check if ID already exists
        if (findPatientByID(id) != null) {
            System.out.println(">>> ERROR: Patient ID already exists!");
            return;
        }

        System.out.print("Enter First Name: ");
        String fName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();

        System.out.print("Enter Age: ");
        int age = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Enter Gender: ");
        String gender = input.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = input.nextLine();

        System.out.print("Enter Patient Category (Inpatient/Outpatient/Emergency): ");
        String category = input.nextLine();

        // Create a new Patient object and add it to our list
        Patient newPatient = new Patient(id, fName, lName, age, gender, condition, category);
        patientList.add(newPatient);

        System.out.println(">>> Patient registered successfully!");
    }

    // ===================================================================
    // METHOD 2: Search for a patient using their ID
    // ===================================================================
    public static void searchPatient() {
        System.out.print("\nEnter Patient ID to search: ");
        String searchID = input.nextLine();

        Patient p = findPatientByID(searchID);

        if (p != null) {
            System.out.println("Patient found!");
            p.displayPatient();
        } else {
            System.out.println("Patient with ID " + searchID + " not found.");
        }
    }

    // ===================================================================
    // METHOD 3: Update an existing patient's details
    // ===================================================================
    public static void updatePatient() {
        System.out.print("\nEnter Patient ID to update: ");
        String searchID = input.nextLine();

        Patient p = findPatientByID(searchID);

        if (p != null) {
            System.out.println("Patient found! Enter new details below:");

            System.out.print("Enter New First Name: ");
            p.setFirstName(input.nextLine());

            System.out.print("Enter New Last Name: ");
            p.setLastName(input.nextLine());

            System.out.print("Enter New Age: ");
            p.setAge(input.nextInt());
            input.nextLine(); // clear buffer

            System.out.print("Enter New Gender: ");
            p.setGender(input.nextLine());

            System.out.print("Enter New Medical Condition: ");
            p.setMedicalCondition(input.nextLine());

            System.out.print("Enter New Category (Inpatient/Outpatient/Emergency): ");
            p.setPatientCategory(input.nextLine());

            System.out.println(">>> Patient details updated successfully!");
        } else {
            System.out.println("Patient with ID " + searchID + " not found.");
        }
    }

    // ===================================================================
    // METHOD 4: Delete a patient
    // ===================================================================
    public static void deletePatient() {
        System.out.print("\nEnter Patient ID to delete: ");
        String searchID = input.nextLine();

        for (int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);

            if (p.getPatientID().equals(searchID)) {
                patientList.remove(i); // removes the patient from the list

                // Also release their bed if they have one
                for (int row = 0; row < 4; row++) {
                    for (int col = 0; col < 5; col++) {
                        if (bedOccupants[row][col] != null && bedOccupants[row][col].equals(searchID)) {
                            bedOccupants[row][col] = null;
                            System.out.println(">>> Bed " + getBedName(row, col) + " has been released.");
                        }
                    }
                }

                System.out.println(">>> Patient deleted successfully!");
                return;
            }
        }

        System.out.println("Patient with ID " + searchID + " not found.");
    }

    // ===================================================================
    // YOUTUBE REFERENCE: Java For-Each Loop
    // https://www.youtube.com/watch?v=_IT8F5W0ZO4
    // ===================================================================

    // ===================================================================
    // METHOD 5: Display all registered patients
    // ===================================================================
    public static void displayAllPatients() {
        if (patientList.size() == 0) {
            System.out.println("\nNo patients registered yet.");
        } else {
            System.out.println("\n========== ALL REGISTERED PATIENTS ==========");

            // for-each loop: automatically goes through every patient in the list
            for (Patient p : patientList) {
                p.displayPatient();
            }
        }
    }

    // ===================================================================
    // METHOD 6: Allocate an available bed to an Inpatient
    // Only Inpatients may be allocated a bed.
    // ===================================================================
    public static void allocateBed() {
        System.out.println("\n--- Allocate Bed to Inpatient ---");

        System.out.print("Enter Patient ID: ");
        String id = input.nextLine();

        // Step 1: Find the patient
        Patient p = findPatientByID(id);

        if (p == null) {
            System.out.println(">>> ERROR: Patient not found.");
            return;
        }

        // Step 2: Check if the patient is an Inpatient
        // equalsIgnoreCase ignores uppercase/lowercase differences
        if (!p.getPatientCategory().equalsIgnoreCase("Inpatient")) {
            System.out.println(">>> ERROR: Only Inpatients can be allocated a bed.");
            System.out.println("    This patient is: " + p.getPatientCategory());
            return;
        }

        // Step 3: Check if patient already has a bed
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                if (bedOccupants[row][col] != null && bedOccupants[row][col].equals(id)) {
                    System.out.println(">>> ERROR: This patient already has bed " + getBedName(row, col));
                    return;
                }
            }
        }

        // Step 4: Find the FIRST available bed (null = available)
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                if (bedOccupants[row][col] == null) {
                    bedOccupants[row][col] = id;
                    System.out.println(">>> SUCCESS: Bed " + getBedName(row, col) +
                                       " allocated to Patient " + id);
                    return; // stop searching once we found a bed
                }
            }
        }

        // Step 5: If we get here, no bed was found
        System.out.println(">>> ERROR: No beds are available. All 20 beds are occupied.");
    }

    // ===================================================================
    // METHOD 7: Release a bed when a patient is discharged
    // ===================================================================
    public static void releaseBed() {
        System.out.println("\n--- Release a Bed ---");

        System.out.print("Enter Bed Number to release (1-20): ");
        int bedNum = input.nextInt();
        input.nextLine(); // clear buffer

        // Validate input range
        if (bedNum < 1 || bedNum > 20) {
            System.out.println(">>> ERROR: Invalid bed number. Must be between 1 and 20.");
            return;
        }

        // Convert bed number (1-20) to row and column in the 2D array
        // Example: Bed 1  -> row 0, col 0
        //          Bed 6  -> row 1, col 0
        //          Bed 20 -> row 3, col 4
        int row = (bedNum - 1) / 5;   // integer division gives the row
        int col = (bedNum - 1) % 5;   // remainder gives the column

        if (bedOccupants[row][col] == null) {
            System.out.println(">>> Bed " + getBedName(row, col) + " is already available.");
        } else {
            String patientID = bedOccupants[row][col];
            bedOccupants[row][col] = null; // make the bed available again
            System.out.println(">>> Bed " + getBedName(row, col) +
                               " released. Was occupied by Patient: " + patientID);
        }
    }

    // ===================================================================
    // METHOD 8: Display the complete ward layout (4 rows x 5 columns)
    // ===================================================================
    public static void displayWardLayout() {
        System.out.println("\n========== WARD LAYOUT (4 x 5) ==========");

        // Nested loops: outer loop = rows, inner loop = columns
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                String bedName = getBedName(row, col);

                if (bedOccupants[row][col] == null) {
                    // Available bed
                    System.out.print(bedName + "[AVAIL]  ");
                } else {
                    // Occupied bed - show patient ID
                    System.out.print(bedName + "[" + bedOccupants[row][col] + "]  ");
                }
            }
            System.out.println(); // move to next line after each row
        }
        System.out.println("=========================================");
    }

    // ===================================================================
    // METHOD 9: Display all available beds
    // ===================================================================
    public static void displayAvailableBeds() {
        System.out.println("\n--- Available Beds ---");

        boolean foundAny = false;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                if (bedOccupants[row][col] == null) {
                    System.out.println("  " + getBedName(row, col) + " - AVAILABLE");
                    foundAny = true;
                }
            }
        }

        if (foundAny == false) {
            System.out.println(">>> No beds available. All 20 beds are occupied.");
        }
    }

public static void displayOccupiedBeds() {
    System.out.println("\n--- Occupied Beds ---");
    
    boolean foundAny = false;
    
    for (int row = 0; row < 4; row++) {
        for (int col = 0; col < 5; col++) {
            if (bedOccupants[row][col] != null) {
                System.out.println(" " + bedOccupants[row][col]);
                foundAny = true; // Set this to true when an occupant is found
            }
        }
    }
}
}