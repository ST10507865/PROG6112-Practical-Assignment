package com.mycompany.patientmanagementsystem;

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

    // method that runs when we create a new Patient
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
// https://www.youtube.com/watch?v=ZjHJrmYknrk
// https://www.youtube.com/watch?v=B7AEJvEhmXo
public class PatientManagementSystem {

    // ArrayList 
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = 0;

        // do-while loop
        do {
            System.out.println("\n===== PATIENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Register a New Patient");
            System.out.println("2. Search for a Patient by ID");
            System.out.println("3. Update Patient Details");
            System.out.println("4. Delete a Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            choice = input.nextInt();
            input.nextLine(); 
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
                    System.out.println("Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please type 1 to 6 only.");
            }

        } while (choice != 6); 
        input.close(); 
    }
    // Register a new patient
    public static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");

        System.out.print("Enter Patient ID: ");
        String id = input.nextLine();

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

        Patient newPatient = new Patient(id, fName, lName, age, gender, condition, category);
        patientList.add(newPatient);

        System.out.println(">>> Patient registered successfully!");
    }

    // Search for a patient using their ID
    public static void searchPatient() {
        System.out.print("\nEnter Patient ID to search: ");
        String searchID = input.nextLine();

        boolean found = false;

        // Loop through the list one by one
        for (int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);

            // Use .equals() to compare Strings (NOT ==)
            if (p.getPatientID().equals(searchID)) {
                System.out.println("Patient found!");
                p.displayPatient();
                found = true;
                break; 
            }
        }

        if (found == false) {
            System.out.println("Patient with ID " + searchID + " not found.");
        }
    }

    //Update an existing patient's details
    public static void updatePatient() {
        System.out.print("\nEnter Patient ID to update: ");
        String searchID = input.nextLine();

        boolean found = false;

        for (int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);

            if (p.getPatientID().equals(searchID)) {
                found = true;
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
                break;
            }
        }

        if (found == false) {
            System.out.println("Patient with ID " + searchID + " not found.");
        }
    }

    // Delete a patient
    public static void deletePatient() {
        System.out.print("\nEnter Patient ID to delete: ");
        String searchID = input.nextLine();

        boolean found = false;

        for (int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);

            if (p.getPatientID().equals(searchID)) {
                patientList.remove(i); // removes the patient from the list
                System.out.println(">>> Patient deleted successfully!");
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("Patient with ID " + searchID + " not found.");
        }
    }
    // https://www.youtube.com/watch?v=_IT8F5W0ZO4
    // Display all registered patients
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
}
