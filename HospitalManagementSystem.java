import java.util.*;

class Patient {
    int id;
    String name, disease;
    int age;
    
    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

class Doctor {
    int id;
    String name, specialization;
    
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }
}

class Appointment {
    int patientId, doctorId;
    String date;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId + ", Doctor ID: " + doctorId + ", Date: " + date);
    }
}

class Bill {
    int patientId;
    double amount;

    public Bill(int patientId, double amount) {
        this.patientId = patientId;
        this.amount = amount;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId + ", Total Bill: $" + amount);
    }
}

class Inventory {
    String itemName;
    int quantity;

    public Inventory(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("Item: " + itemName + ", Quantity: " + quantity);
    }
}

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Bill> bills = new ArrayList<>();
    static List<Inventory> inventory = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Generate Bill");
            System.out.println("8. View Bills");
            System.out.println("9. Manage Inventory");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1: registerPatient(); break;
                case 2: addDoctor(); break;
                case 3: scheduleAppointment(); break;
                case 4: viewPatients(); break;
                case 5: viewDoctors(); break;
                case 6: viewAppointments(); break;
                case 7: generateBill(); break;
                case 8: viewBills(); break;
                case 9: manageInventory(); break;
                case 10: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }

    static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();
        
        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient Registered Successfully.");
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor Added Successfully.");
    }

    static void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        appointments.add(new Appointment(patientId, doctorId, date));
        System.out.println("Appointment Scheduled Successfully.");
    }

    static void viewPatients() {
        System.out.println("\n=== Patient List ===");
        for (Patient p : patients) {
            p.display();
        }
    }

    static void viewDoctors() {
        System.out.println("\n=== Doctor List ===");
        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void viewAppointments() {
        System.out.println("\n=== Appointment List ===");
        for (Appointment a : appointments) {
            a.display();
        }
    }

    static void generateBill() {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter Amount: $");
        double amount = sc.nextDouble();

        bills.add(new Bill(patientId, amount));
        System.out.println("Bill Generated Successfully.");
    }

    static void viewBills() {
        System.out.println("\n=== Billing Records ===");
        for (Bill b : bills) {
            b.display();
        }
    }

    static void manageInventory() {
        System.out.print("Enter Item Name: ");
        sc.nextLine();
        String itemName = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        inventory.add(new Inventory(itemName, quantity));
        System.out.println("Inventory Updated Successfully.");
    }
}

