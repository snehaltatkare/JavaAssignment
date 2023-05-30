import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.print("Enter the value of A: ");
        int a = s1.nextInt();

        System.out.print("Enter the value of B: ");
        int b = s1.nextInt();

        System.out.println("Before swapping:");
        System.out.println("A = " + a);
        System.out.println("B = " + b);

        // Swapping the values
        int c = a;
        a = b;
        b = c;

        System.out.println("After swapping:");
        System.out.println("A = " + a);
        System.out.println("B = " + b);

    }
}

