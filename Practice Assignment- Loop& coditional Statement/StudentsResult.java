import java.util.Scanner;

public class StudentsResult {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.print("Enter the Marks Obtained by a Student: ");
        double MarksObtained = s1.nextDouble();

        System.out.print("Enter the Total Marks: ");
        double TotalMarks = s1.nextDouble();

        double percentage = (MarksObtained / TotalMarks) * 100;
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");

        double gpa;
        String grade;

        if (percentage >= 90) {
            grade = "A";
            gpa = 4.0;
        } else if (percentage >= 80) {
            grade = "B";
            gpa = 3.0;
        } else if (percentage >= 70) {
            grade = "C";
            gpa = 2.0;
        } else if (percentage >= 60) {
            grade = "D";
            gpa = 1.0;
        } else {
            grade = "F";
            gpa = 0.0;
        }

        System.out.println("Grade " + grade + ", GPA = " + gpa);

    }
}

