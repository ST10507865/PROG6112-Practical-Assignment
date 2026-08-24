package com.mycompany.hospitalpatientcategories;


 // Website: https://www.w3schools.com/java/java_enums.asp
 // Video:   https://www.youtube.com/watch?v=wqhB2MJn1Xk 
 
enum PatientCategory {
    INPATIENT,
    OUTPATIENT,
    EMERGENCY
}


 // Website: https://www.javatpoint.com/java-oops-concepts
 // Video:   https://www.youtube.com/watch?v=pTB0EiLXUC8 
 
class Patient {
    protected String patientName;
    protected int patientID;
    protected PatientCategory category;

    
     // Website: https://www.geeksforgeeks.org/constructors-in-java/
     // Video:   https://www.youtube.com/watch?v=tDn-GFArvK4 (Alex Lee - Java Constructors)
    
    public Patient(String name, int id, PatientCategory cat) {
        this.patientName = name;
        this.patientID = id;
        this.category = cat;
    }
    public String getName() {
        return patientName;
    }

    public int getID() {
        return patientID;
    }

    public PatientCategory getCategory() {
        return category;
    }

    
     // Website: https://www.w3schools.com/java/java_methods.asp
     // Video:   https://www.youtube.com/watch?v=vZm0lHciFsQ (Bro Code - Java Methods)
     
    public void displayDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + patientName);
        System.out.println("Category: " + category);
    }
}


 // Website: https://www.w3schools.com/java/java_inheritance.asp
 // Video:   https://www.youtube.com/watch?v=9JpNY-XAseg (
 
class Inpatient extends Patient {
    
    private String wardNumber;
    private int bedNumber;

   
     // Website: https://www.geeksforgeeks.org/super-keyword/
     // Video:   https://www.youtube.com/watch?v=Qb_NUn0T6jY 
     
    public Inpatient(String name, int id, PatientCategory cat, String ward, int bed) {
        super(name, id, cat);   
        this.wardNumber = ward;
        this.bedNumber = bed;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }

   
     // Website: https://www.geeksforgeeks.org/overriding-in-java/
     
    @Override
    public void displayDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + patientName);
        System.out.println("Category: " + category);
        System.out.println("Ward Number: " + wardNumber);
        System.out.println("Bed Number: " + bedNumber);
    }
}


// MAIN CLASS TO TEST FEATURE 4
public class HospitalPatientCategories {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   FEATURE 4: PATIENT CATEGORIES");
        System.out.println("========================================\n");

        
         // Website: https://www.w3schools.com/java/java_classes.asp
         // Video:   https://www.youtube.com/watch?v=IUqKuGNasdM (Programming with Mosh - Objects)
         

        // 1. Outpatient - uses base Patient class
        Patient outPatient = new Patient("Thabo Mokoena", 1001, PatientCategory.OUTPATIENT);
        System.out.println("--- Outpatient Details ---");
        outPatient.displayDetails();
        System.out.println();

        // 2. Emergency - uses base Patient class
        Patient emergencyPatient = new Patient("Sarah Jones", 1002, PatientCategory.EMERGENCY);
        System.out.println("--- Emergency Patient Details ---");
        emergencyPatient.displayDetails();
        System.out.println();

       
         //Website: https://www.javatpoint.com/inheritance-in-java
        Inpatient inPatient = new Inpatient("John Doe", 1003, PatientCategory.INPATIENT, "Ward A", 12);
        System.out.println("--- Inpatient Details ---");
        inPatient.displayDetails();
        System.out.println();

        // Show that Inpatient inherited getName() from Patient
        System.out.println("Accessing inherited method:");
        System.out.println("Inpatient name (from getter): " + inPatient.getName());
        System.out.println("Inpatient ward (from getter): " + inPatient.getWardNumber());
    }
}