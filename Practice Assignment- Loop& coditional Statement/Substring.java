import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        System.out.print("Enter the starting index: ");
        int startIndex = input.nextInt();

        System.out.print("Enter the ending index: ");
        int endIndex = input.nextInt();

        String substring = str.substring(startIndex, endIndex);
        System.out.println("Substring: " + substring);

        input.close();
    }
}
