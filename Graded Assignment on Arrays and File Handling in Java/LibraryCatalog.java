import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LibraryCatalog {
        public static void main(String[] args) {
            // Predefined multidimensional array with book information
            String[][] catalog = {
                {"101", "HTML and CSS", "Jon Duckett", "Available", "Null"},
                {"102", "JavaScript: The Good Parts", "Douglas C", "Available", "Null"},
                {"103", "Learning Web Design", "Jennifer N", "CP2014", "23-May-2023"},
                {"104", "Responsive Web Design", "Ben Frain", "EC3142", "17-May-2023"}
            };
    
            // Display all books
            System.out.println("List of all Books");
            System.out.println("Book ID\t\tBook Title\t\tAuthor\t\tAvailability\t\tIssue Date");
    
            for (String[] book : catalog) {
                for (String field : book) {
                    System.out.print(field + "\t\t");
                }
                System.out.println();
            }
        }
    
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    issueBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("----- Welcome to the Unique Library -----");
        System.out.println("1. View the complete list of Books");
        System.out.println("2. Issue a book");
        System.out.println("3. Return a book");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
        System.out.print("Enter your choice: ");
    }

    private static void displayAllBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the catalog.");
        } else {
            System.out.println("----- All Books -----");
            for (int i = 0; i < bookCount; i++) {
                System.out.println("Book ID: " + catalog[i][0]);
                System.out.println("Title: " + catalog[i][1]);
                System.out.println("Author: " + catalog[i][2]);
                System.out.println("Availability: " + catalog[i][3]);
                System.out.println("Issue Date: " + catalog[i][4]);
                System.out.println("--------------------");
            }
        }
    }

    private static void issueBook(Scanner scanner) {
        if (bookCount == MAX_BOOKS) {
            System.out.println("Catalog is full. Cannot issue more books.");
            return;
        }

        System.out.print("Enter the book ID: ");
        String bookID = scanner.nextLine();

        int bookIndex = findBookIndex(bookID);
        if (bookIndex == -1) {
            System.out.println("Book not found in the catalog.");
            return;
        }

        if (!catalog[bookIndex][3].equals("available")) {
            System.out.println("Book is already issued to a student.");
            return;
        }

        System.out.print("Enter the student ID: ");
        String studentID = scanner.nextLine();
        catalog[bookIndex][3] = studentID;
        catalog[bookIndex][4] = LocalDate.now().toString();

        System.out.println("Book issued successfully to Student ID: " + studentID);
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter the book ID: ");
        String bookID = scanner.nextLine();

        int bookIndex = findBookIndex(bookID);
        if (bookIndex == -1) {
            System.out.println("Book not found in the catalog.");
            return;
        }

        if (catalog[bookIndex][3].equals("available")) {
            System.out.println("Book is already available in the catalog.");
            return;
        }

        String studentID = catalog[bookIndex][3];
        LocalDate issueDate = LocalDate.parse(catalog[bookIndex][4]);
        long daysPassed = ChronoUnit.DAYS.between(issueDate, LocalDate.now());

        if (daysPassed > 7) {
            double charges = 10.0 * (daysPassed - 7);
            System.out.println("Book returned after " + daysPassed + " days. Charges: Rs. " + charges);
        } else {
            System.out.println("Book returned within the allowed period. No charges.");
        }

        catalog[bookIndex][3] = "available";
        catalog[bookIndex][4] = "Null";
        System.out.println("Book returned successfully by Student ID: " + studentID);
    }

    private static int findBookIndex(String bookID) {
        for (int i = 0; i < bookCount; i++) {
            if (catalog[i][0].equals(bookID)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "LibraryCatalog []";
    }
}

