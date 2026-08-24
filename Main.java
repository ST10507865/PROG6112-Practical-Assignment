package com.mycompany.main;

import java.util.Scanner;
import java.util.ArrayList;
 
  // References
 // ArrayList:
 // https://www.w3schools.com/java/java_arraylist.asp
 // https://www.youtube.com/watch?v=1hUUsLDubzI
 
 // Main method:
 // https://www.geeksforgeeks.org/java-main-method-public-static-void-main-string-args/
 //https://www.youtube.com/watch?v=BGTx91t8q50
 
 // Do-While / Menu:
 // https://www.youtube.com/watch?v=ZjHJrmYknrk
 
 //Switch statements:
 // https://www.youtube.com/watch?v=B7AEJvEhmXo
 
 // 2D arrays:
 // https://www.youtube.com/watch?v=qwgFU7HO8C8
 
 // For-each loop:
 // https://www.youtube.com/watch?v=_IT8F5W0ZO4
 
 // For loop:
 // https://www.w3schools.com/java/java_for_loop.asp
 
 // Type casting:
 // https://www.w3schools.com/java/java_type_casting.asp
 
 // Enums:
 // https://www.w3schools.com/java/java_enums.asp
 // https://www.youtube.com/watch?v=wqhB2MJn1Xk
 
 // Inheritance:
 // https://www.w3schools.com/java/java_inheritance.asp
 // https://www.youtube.com/watch?v=9JpNY-XAseg
 
 // super keyword:
 // https://www.geeksforgeeks.org/super-keyword/
 
 // Method overriding:
 // https://www.geeksforgeeks.org/overriding-in-java/
 
 // Classes and objects:
 // https://www.w3schools.com/java/java_classes.asp
 // https://www.youtube.com/watch?v=IUqKuGNasdM
 
 // Inheritance in Java:
 // https://www.javatpoint.com/inheritance-in-java

 
enum PatientCategory {
    INPATIENT,
    OUTPATIENT,
    EMERGENCY
}
class Patient {

    // Private variables store patient information.
    private String patientID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private PatientCategory patientCategory;

    public Patient(String patientID, String firstName, String lastName,
                   int age, String gender, String medicalCondition,
                   PatientCategory patientCategory) {

        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.patientCategory = patientCategory;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public PatientCategory getPatientCategory() {
        return patientCategory;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void setPatientCategory(PatientCategory patientCategory) {
        this.patientCategory = patientCategory;
    }

    // Displays the complete patient information.
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

    // Method from the patient-category feature.
    public void displayDetails() {
        displayPatient();
    }
}
// Feature 2
class Inpatient extends Patient {

    private String wardNumber;
    private int bedNumber;

    public Inpatient(String patientID, String firstName, String lastName,
                     int age, String gender, String medicalCondition,
                     String wardNumber, int bedNumber) {

        super(patientID, firstName, lastName, age, gender,
              medicalCondition, PatientCategory.INPATIENT);

        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Patient ID: " + getPatientID());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Medical Condition: " + getMedicalCondition());
        System.out.println("Category: " + getPatientCategory());
        System.out.println("Ward Number: " + wardNumber);
        System.out.println("Bed Number: " + bedNumber);
        System.out.println("----------------------------------------");
    }
}
class Bed {

    int bedNumber;
    String ward;
    boolean isOccupied;
    Patient patient;

    public Bed(int num, String ward) {
        this.bedNumber = num;
        this.ward = ward;
        this.isOccupied = false;
        this.patient = null;
    }
}

public class Main {

    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static ArrayList<Bed> beds = new ArrayList<Bed>();
    static Scanner input = new Scanner(System.in);

    static String[][] bedOccupants = new String[4][5];


    public static void main(String[] args) {

        // Create 20 beds for the reporting feature.
        initializeBeds();

        int choice = 0;

      
        do {

            System.out.println("\n==============================================");
            System.out.println("        HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("==============================================");

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

            System.out.println("----- REPORTS -----");
            System.out.println("11. Display All Registered Patients Report");
            System.out.println("12. Display Total Registered Patients");
            System.out.println("13. Display Total Occupied Beds");
            System.out.println("14. Display Ward Occupancy Percentage");
            System.out.println("15. Display Complete Hospital Report");

            System.out.println("16. Exit");

            System.out.print("Enter your choice (1-16): ");

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
                    displayAllRegisteredPatients();
                    break;

                case 12:
                    displayTotalRegisteredPatients();
                    break;

                case 13:
                    displayTotalOccupiedBeds();
                    break;

                case 14:
                    displayWardOccupancyPercentage();
                    break;

                case 15:
                    displayCompleteHospitalReport();
                    break;

                case 16:
                    System.out.println("Thank you! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice. Please type 1 to 16 only.");
            }

        } while (choice != 16);

        input.close();
    }
    public static void initializeBeds() {

        for (int i = 1; i <= 20; i++) {

            String ward;

            if (i <= 10) {
                ward = "Ward A";
            } else {
                ward = "Ward B";
            }

            beds.add(new Bed(i, ward));
        }
    }

    public static Patient findPatientByID(String id) {

        for (int i = 0; i < patientList.size(); i++) {

            Patient p = patientList.get(i);

            if (p.getPatientID().equals(id)) {
                return p;
            }
        }

        return null;
    }
    public static String getBedName(int row, int col) {

        int bedNumber = (row * 5) + col + 1;

        if (bedNumber < 10) {
            return "B0" + bedNumber;
        } else {
            return "B" + bedNumber;
        }
    }

    public static void registerPatient() {

        System.out.println("\n--- Register New Patient ---");

        System.out.print("Enter Patient ID: ");
        String id = input.nextLine();

        // Check that the patient ID is not already used.
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
        input.nextLine();

        System.out.print("Enter Gender: ");
        String gender = input.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = input.nextLine();

        PatientCategory category = readPatientCategory();

        Patient newPatient;

        if (category == PatientCategory.INPATIENT) {

            System.out.print("Enter Ward Number: ");
            String ward = input.nextLine();

            newPatient = new Inpatient(
                    id, fName, lName, age, gender,
                    condition, ward, 0
            );

        } else {

            newPatient = new Patient(
                    id, fName, lName, age, gender,
                    condition, category
            );
        }

        patientList.add(newPatient);

        System.out.println(">>> Patient registered successfully!");
    }
    public static PatientCategory readPatientCategory() {

        while (true) {

            System.out.print(
                    "Enter Patient Category (Inpatient/Outpatient/Emergency): "
            );

            String category = input.nextLine();

            if (category.equalsIgnoreCase("Inpatient")) {
                return PatientCategory.INPATIENT;
            }

            if (category.equalsIgnoreCase("Outpatient")) {
                return PatientCategory.OUTPATIENT;
            }

            if (category.equalsIgnoreCase("Emergency")) {
                return PatientCategory.EMERGENCY;
            }

            System.out.println(
                    "Invalid category. Please enter Inpatient, Outpatient or Emergency."
            );
        }
    }


    /*
     * METHOD 2: Search for a patient using their ID.
     */
    public static void searchPatient() {

        System.out.print("\nEnter Patient ID to search: ");
        String searchID = input.nextLine();

        Patient p = findPatientByID(searchID);

        if (p != null) {

            System.out.println("Patient found!");
            p.displayDetails();

        } else {

            System.out.println(
                    "Patient with ID " + searchID + " not found."
            );
        }
    }
    public static void updatePatient() {

        System.out.print("\nEnter Patient ID to update: ");
        String searchID = input.nextLine();

        Patient p = findPatientByID(searchID);

        if (p != null) {

            System.out.println(
                    "Patient found! Enter new details below:"
            );

            System.out.print("Enter New First Name: ");
            p.setFirstName(input.nextLine());

            System.out.print("Enter New Last Name: ");
            p.setLastName(input.nextLine());

            System.out.print("Enter New Age: ");
            p.setAge(input.nextInt());
            input.nextLine();

            System.out.print("Enter New Gender: ");
            p.setGender(input.nextLine());

            System.out.print("Enter New Medical Condition: ");
            p.setMedicalCondition(input.nextLine());

            PatientCategory oldCategory = p.getPatientCategory();
            PatientCategory newCategory = readPatientCategory();

            p.setPatientCategory(newCategory);

            System.out.println(">>> Patient details updated successfully!");

            if (oldCategory != newCategory) {
                System.out.println(
                        ">>> Patient category changed from "
                        + oldCategory + " to " + newCategory + "."
                );
            }

        } else {

            System.out.println(
                    "Patient with ID " + searchID + " not found."
            );
        }
    }
    public static void deletePatient() {

        System.out.print("\nEnter Patient ID to delete: ");
        String searchID = input.nextLine();

        for (int i = 0; i < patientList.size(); i++) {

            Patient p = patientList.get(i);

            if (p.getPatientID().equals(searchID)) {

                patientList.remove(i);

                // Release any bed belonging to this patient.
                for (int row = 0; row < 4; row++) {

                    for (int col = 0; col < 5; col++) {

                        if (bedOccupants[row][col] != null
                                && bedOccupants[row][col].equals(searchID)) {

                            bedOccupants[row][col] = null;

                            updateBedList(
                                    (row * 5) + col + 1,
                                    null
                            );

                            System.out.println(
                                    ">>> Bed " + getBedName(row, col)
                                    + " has been released."
                            );
                        }
                    }
                }

                System.out.println(
                        ">>> Patient deleted successfully!"
                );

                return;
            }
        }

        System.out.println(
                "Patient with ID " + searchID + " not found."
        );
    }
     // https://www.youtube.com/watch?v=_IT8F5W0ZO4
    public static void displayAllPatients() {

        if (patientList.size() == 0) {

            System.out.println("\nNo patients registered yet.");

        } else {

            System.out.println(
                    "\n========== ALL REGISTERED PATIENTS =========="
            );

            for (Patient p : patientList) {
                p.displayDetails();
            }
        }
    }
    public static void allocateBed() {

        System.out.println("\n--- Allocate Bed to Inpatient ---");

        System.out.print("Enter Patient ID: ");
        String id = input.nextLine();

        Patient p = findPatientByID(id);

        if (p == null) {

            System.out.println(">>> ERROR: Patient not found.");
            return;
        }

        if (p.getPatientCategory() != PatientCategory.INPATIENT) {

            System.out.println(
                    ">>> ERROR: Only Inpatients can be allocated a bed."
            );

            System.out.println(
                    "This patient is: " + p.getPatientCategory()
            );

            return;
        }

        // Check if patient already has a bed.
        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                if (bedOccupants[row][col] != null
                        && bedOccupants[row][col].equals(id)) {

                    System.out.println(
                            ">>> ERROR: This patient already has bed "
                            + getBedName(row, col)
                    );

                    return;
                }
            }
        }

        // Find the first available bed.
        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                if (bedOccupants[row][col] == null) {

                    int bedNumber = (row * 5) + col + 1;

                    bedOccupants[row][col] = id;

                    updateBedList(bedNumber, p);

                    System.out.println(
                            ">>> SUCCESS: Bed "
                            + getBedName(row, col)
                            + " allocated to Patient " + id
                    );

                    return;
                }
            }
        }

        System.out.println(
                ">>> ERROR: No beds are available. All 20 beds are occupied."
        );
    }
    public static void releaseBed() {

        System.out.println("\n--- Release a Bed ---");

        System.out.print("Enter Bed Number to release (1-20): ");
        int bedNum = input.nextInt();
        input.nextLine();

        if (bedNum < 1 || bedNum > 20) {

            System.out.println(
                    ">>> ERROR: Invalid bed number. Must be between 1 and 20."
            );

            return;
        }

        int row = (bedNum - 1) / 5;
        int col = (bedNum - 1) % 5;

        if (bedOccupants[row][col] == null) {

            System.out.println(
                    ">>> Bed " + getBedName(row, col)
                    + " is already available."
            );

        } else {

            String patientID = bedOccupants[row][col];

            bedOccupants[row][col] = null;

            updateBedList(bedNum, null);

            System.out.println(
                    ">>> Bed " + getBedName(row, col)
                    + " released. Was occupied by Patient: "
                    + patientID
            );
        }
    }


    
     // Display complete ward layout.
    public static void displayWardLayout() {

        System.out.println(
                "\n========== WARD LAYOUT (4 x 5) =========="
        );

        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                String bedName = getBedName(row, col);

                if (bedOccupants[row][col] == null) {

                    System.out.print(
                            bedName + "[AVAIL]  "
                    );

                } else {

                    System.out.print(
                            bedName + "["
                            + bedOccupants[row][col]
                            + "]  "
                    );
                }
            }

            System.out.println();
        }

        System.out.println(
                "========================================="
        );
    }


    /*
     * METHOD 9: Display all available beds.
     */
    public static void displayAvailableBeds() {

        System.out.println("\n--- Available Beds ---");

        boolean foundAny = false;

        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                if (bedOccupants[row][col] == null) {

                    System.out.println(
                            "  " + getBedName(row, col)
                            + " - AVAILABLE"
                    );

                    foundAny = true;
                }
            }
        }

        if (foundAny == false) {

            System.out.println(
                    ">>> No beds available. All 20 beds are occupied."
            );
        }
    }


    /*
     * METHOD 10: Display all occupied beds.
     */
    public static void displayOccupiedBeds() {

        System.out.println("\n--- Occupied Beds ---");

        boolean foundAny = false;

        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                if (bedOccupants[row][col] != null) {

                    System.out.println(
                            "  " + getBedName(row, col)
                            + " - Patient: "
                            + bedOccupants[row][col]
                    );

                    foundAny = true;
                }
            }
        }

        if (foundAny == false) {
            System.out.println("No occupied beds.");
        }
    }
     //https://www.w3schools.com/java/java_for_loop.asp
    public static void displayAllRegisteredPatients() {

        System.out.println("\n--- All Registered Patients ---");

        if (patientList.size() == 0) {

            System.out.println("No patients registered.");
            return;
        }

        for (int i = 0; i < patientList.size(); i++) {

            Patient p = patientList.get(i);

            System.out.println(
                    "ID: " + p.getPatientID()
                    + " | Name: "
                    + p.getFirstName() + " "
                    + p.getLastName()
                    + " | Category: "
                    + p.getPatientCategory()
            );
        }
    }
     //https://www.geeksforgeeks.org/arraylist-size-method-in-java/
    public static void displayTotalRegisteredPatients() {

        System.out.println(
                "\n--- Total Registered Patients ---"
        );

        int total = patientList.size();

        System.out.println("Total: " + total);
    }
    public static void displayTotalOccupiedBeds() {

        System.out.println(
                "\n--- Total Occupied Beds ---"
        );

        int count = 0;

        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                if (bedOccupants[row][col] != null) {
                    count++;
                }
            }
        }

        System.out.println("Total Occupied: " + count);
    }


    
     // Display ward occupancy percentage.
     // https://www.w3schools.com/java/java_type_casting.asp
     
    public static void displayWardOccupancyPercentage() {

        System.out.println(
                "\n--- Ward Occupancy Percentage ---"
        );

        int totalBeds = 20;

        int occupied = 0;

        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 5; col++) {

                if (bedOccupants[row][col] != null) {
                    occupied++;
                }
            }
        }

        double percentage =
                ((double) occupied / totalBeds) * 100;

        System.out.println("Total Beds: " + totalBeds);
        System.out.println("Occupied: " + occupied);
        System.out.println("Available: " + (totalBeds - occupied));
        System.out.println(
                "Occupancy Percentage: " + percentage + "%"
        );
    }
    // Complete hospital report.
    public static void displayCompleteHospitalReport() {

        System.out.println(
                "\n================================================"
        );
        System.out.println(
                "           COMPLETE HOSPITAL REPORT"
        );
        System.out.println(
                "================================================"
        );

        displayAllRegisteredPatients();

        System.out.println();
        displayAvailableBeds();

        System.out.println();
        displayOccupiedBeds();

        System.out.println();
        displayTotalRegisteredPatients();

        System.out.println();
        displayTotalOccupiedBeds();

        System.out.println();
        displayWardOccupancyPercentage();

        System.out.println(
                "\n================================================"
        );
    }
    public static void updateBedList(int bedNumber, Patient patient) {

        for (int i = 0; i < beds.size(); i++) {

            Bed b = beds.get(i);

            if (b.bedNumber == bedNumber) {

                if (patient == null) {

                    b.isOccupied = false;
                    b.patient = null;

                } else {

                    b.isOccupied = true;
                    b.patient = patient;
                }

                return;
            }
        }
    }
}