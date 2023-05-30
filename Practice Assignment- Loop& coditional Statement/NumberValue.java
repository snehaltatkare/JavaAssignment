import java.util.Scanner;

public class NumberValue {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = s1.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = s1.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = s1.nextInt();

        // Find the smallest number
        int smallest = Math.min(num1, Math.min(num2, num3));

        // Find the largest number
        int largest = Math.max(num1, Math.max(num2, num3));

        // Calculate the average
        double average = (num1 + num2 + num3) / 3.0;

        System.out.println("The Smallest Number: " + smallest);
        System.out.println("The Largest Number: " + largest);
        System.out.println("Average of all three numbers: " + average);
    }
}
