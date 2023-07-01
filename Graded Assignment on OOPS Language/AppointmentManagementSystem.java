import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Visitor {
    private String name;
    private String contactNumber;
    private LocalDate date;
    private LocalTime time;

    public Visitor(String name, String contactNumber, LocalDate date, LocalTime time) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

class Clinic {
    private List<Visitor> visitors;

    public Clinic() {
        this.visitors = new ArrayList<>();
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public void editVisitorDetails(int index, String name, String contactNumber) {
        if (index >= 0 && index < visitors.size()) {
            Visitor visitor = visitors.get(index);
            visitor.setName(name);
            visitor.setContactNumber(contactNumber);
        }
    }

    public void viewVisitorsList() {
        System.out.println("Visitors List:");
        for (int i = 0; i < visitors.size(); i++) {
            Visitor visitor = visitors.get(i);
            System.out.println("Visitor " + (i + 1) + ":");
            System.out.println("Name: " + visitor.getName());
            System.out.println("Contact Number: " + visitor.getContactNumber());
            System.out.println("Date: " + visitor.getDate());
            System.out.println("Time: " + visitor.getTime());
            System.out.println();
        }
    }

    public void viewAppointmentSchedule(LocalDate date) {
        System.out.println("Appointment Schedule for " + date + ":");
        for (Visitor visitor : visitors) {
            if (visitor.getDate().equals(date)) {
                System.out.println("Visitor: " + visitor.getName());
                System.out.println("Time: " + visitor.getTime());
                System.out.println();
            }
        }
    }

    public void bookAppointment(LocalDate date, LocalTime time) {
        Visitor visitor = new Visitor("", "", date, time);
        visitors.add(visitor);
        System.out.println("Appointment booked successfully for " + date + " at " + time);
    }

    public void editCancelAppointment(int index, LocalDate date, LocalTime time) {
        if (index >= 0 && index < visitors.size()) {
            Visitor visitor = visitors.get(index);
            visitor.setDate(date);
            visitor.setTime(time);
            System.out.println("Appointment updated successfully for Visitor " + (index + 1));
        }
    }
}

public class AppointmentManagementSystem {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View list of all Visitors");
            System.out.println("2. Add new Visitor");
            System.out.println("3. Edit Visitor Details");
            System.out.println("4. View Appointment Schedule for a Day");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Edit/Cancel Appointment");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    clinic.viewVisitorsList();
                    break;
                case 2:
                    System.out.print("Enter Visitor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();
                    Visitor visitor = new Visitor(name, contactNumber, date, time);
                    clinic.addVisitor(visitor);
                    System.out.println("Visitor added successfully.");
                    break;
                case 3:
                    System.out.print("Enter Visitor index to edit details: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    System.out.print("Enter new Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    contactNumber = scanner.nextLine();
                    clinic.editVisitorDetails(index - 1, name, contactNumber);
                    System.out.println("Visitor details updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String dateString = scanner.nextLine();
                    date = LocalDate.parse(dateString);
                    clinic.viewAppointmentSchedule(date);
                    break;
                case 5:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    dateString = scanner.nextLine();
                    date = LocalDate.parse(dateString);
                    System.out.print("Enter Time (HH:MM): ");
                    String timeString = scanner.nextLine();
                    time = LocalTime.parse(timeString);
                    clinic.bookAppointment(date, time);
                    break;
                case 6:
                    System.out.print("Enter Visitor index to edit/cancel appointment: ");
                    index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    System.out.print("Enter new Date (YYYY-MM-DD): ");
                    dateString = scanner.nextLine();
                    date = LocalDate.parse(dateString);
                    System.out.print("Enter new Time (HH:MM): ");
                    timeString = scanner.nextLine();
                    time = LocalTime.parse(timeString);
                    clinic.editCancelAppointment(index - 1, date, time);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}
