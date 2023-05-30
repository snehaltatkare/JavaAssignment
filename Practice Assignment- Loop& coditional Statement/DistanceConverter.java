import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        boolean Conversion = true;

        while (Conversion) {
            System.out.println("Menu based app - Unit conversion for Distance");
            System.out.println("1. CM to M");
            System.out.println("2. M to KM");
            System.out.println("3. KM to M");
            System.out.println("4. M to CM");
            System.out.print("Enter your menu: ");
            int menu = s1.nextInt();

            double value;
            double convertedValue = 0;
            String originalUnit = "";
            String targetUnit = "";

            switch (menu) {
                case 1:
                    originalUnit = "CM";
                    targetUnit = "M";
                    System.out.print("Please enter the CM Value: ");
                    value = s1.nextDouble();
                    convertedValue = value / 100;
                    break;
                case 2:
                    originalUnit = "M";
                    targetUnit = "KM";
                    System.out.print("Please enter the M Value: ");
                    value = s1.nextDouble();
                    convertedValue = value / 1000;
                    break;
                case 3:
                    originalUnit = "KM";
                    targetUnit = "M";
                    System.out.print("Please enter the KM Value: ");
                    value = s1.nextDouble();
                    convertedValue = value * 1000;
                    break;
                case 4:
                    originalUnit = "M";
                    targetUnit = "CM";
                    System.out.print("Please enter the M Value: ");
                    value = s1.nextDouble();
                    convertedValue = value * 100;
                    break;
                default:
                    System.out.println("Invalid menu option!");
                    continue;
            }

            System.out.println(value + " " + originalUnit + " = " + convertedValue + " " + targetUnit);

            System.out.print("Do you want to continue (y/n)? ");
            String continueOption = s1.next();
            Conversion = continueOption.equalsIgnoreCase("y");

            System.out.println();
        }
    }
}

