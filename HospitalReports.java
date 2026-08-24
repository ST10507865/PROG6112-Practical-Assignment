package com.mycompany.hospitalreports;
import java.util.ArrayList;

// FEATURE 3: REPORTS 
 // Website: https://www.w3schools.com/java/java_arraylist.asp
 // Video:   https://www.youtube.com/watch?v=1hUUsLDubzI 
class Patient {
    String name;
    int id;

    public Patient(String n, int i) {
        this.name = n;
        this.id = i;
    }
}

class Bed {
    int bedNumber;
    String ward;
    boolean isOccupied;
    Patient patient;

    public Bed(int num, String w) {
        this.bedNumber = num;
        this.ward = w;
        this.isOccupied = false;
        this.patient = null;
    }
}

public class HospitalReports {
    //  list hold the hospital data
    static ArrayList<Patient> patients = new ArrayList<Patient>();
    static ArrayList<Bed> beds = new ArrayList<Bed>();

    public static void main(String[] args) {
        
         //Website: https://www.geeksforgeeks.org/java-main-method-public-static-void-main-string-args/
         //Video:   https://www.youtube.com/watch?v=BGTx91t8q50 (Programming with Mosh)
         

        displayAllRegisteredPatients();
        displayAllAvailableBeds();
        displayAllOccupiedBeds();
        displayTotalRegisteredPatients();
        displayTotalOccupiedBeds();
        displayWardOccupancyPercentage();
    }
    // REPORT 1: Display all registered patients
    public static void displayAllRegisteredPatients() {
        
         // Website: https://www.w3schools.com/java/java_for_loop.asp
         // Video:   https://www.youtube.com/watch?v=hH_8xM0VQFU 
        System.out.println("\n--- All Registered Patients ---");

        if (patients.size() == 0) {
            System.out.println("No patients registered.");
            return;
        }

        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            System.out.println("ID: " + p.id + " | Name: " + p.name);
        }
    }
    // REPORT 2: Display all available beds
    public static void displayAllAvailableBeds() {
       
         //Website: https://www.w3schools.com/java/java_conditions.asp
         // Video:   https://www.youtube.com/watch?v=MY03Cb_8Jyw 
        
        System.out.println("\n--- Available Beds ---");

        boolean found = false;

        for (int i = 0; i < beds.size(); i++) {
            Bed b = beds.get(i);
            if (b.isOccupied == false) {
                System.out.println("Bed " + b.bedNumber + " | Ward: " + b.ward + " | Status: AVAILABLE");
                found = true;
            }
        }

        if (found == false) {
            System.out.println("No available beds.");
        }
    }
    // REPORT 3: Display all occupied beds
    public static void displayAllOccupiedBeds() {
        System.out.println("\n--- Occupied Beds ---");

        boolean found = false;

        for (int i = 0; i < beds.size(); i++) {
            Bed b = beds.get(i);
            if (b.isOccupied == true) {
                System.out.println("Bed " + b.bedNumber + " | Ward: " + b.ward
                        + " | Patient: " + b.patient.name);
                found = true;
            }
        }

        if (found == false) {
            System.out.println("No occupied beds.");
        }
    }
    // REPORT 4: Display total number of registered patients
    public static void displayTotalRegisteredPatients() {
     
         //Website: https://www.geeksforgeeks.org/arraylist-size-method-in-java/
        System.out.println("\n--- Total Registered Patients ---");
        int total = patients.size();
        System.out.println("Total: " + total);
    }

    // REPORT 5: Display total number of occupied beds
    public static void displayTotalOccupiedBeds() {
        System.out.println("\n--- Total Occupied Beds ---");

        int count = 0;

        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).isOccupied == true) {
                count = count + 1;
            }
        }

        System.out.println("Total Occupied: " + count);
    }

    
    // REPORT 6: Display ward occupancy percentage
    public static void displayWardOccupancyPercentage() {
        
         //Website: https://www.w3schools.com/java/java_type_casting.asp
         //Video:   https://www.youtube.com/watch?v=Ok3-uz8N3sE 
         
        System.out.println("\n--- Ward Occupancy Percentage ---");

        int totalBeds = beds.size();

        if (totalBeds == 0) {
            System.out.println("No beds in the system.");
            return;
        }

        int occupied = 0;

        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).isOccupied == true) {
                occupied++;
            }
        }

        // Cast to double so we get decimal answer
        double percentage = ((double) occupied / totalBeds) * 100;

        System.out.println("Total Beds: " + totalBeds);
        System.out.println("Occupied: " + occupied);
        System.out.println("Available: " + (totalBeds - occupied));
        System.out.println("Occupancy Percentage: " + percentage + "%");
    }
}