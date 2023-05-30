import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome to the SmartPoint Electronics Store");
        System.out.println("-----------------------------------------------------");

        String[] productNames = {
            "Mobile", "Laptop", "Tablet", "Portable HDD", "Bluetooth Headphone",
            "Smart-watch", "Digital Camera", "Portable Power bank", "Printer", "Wireless Router"
        };

        String[] specifications = {
            "Specs for Mobile", "Specs for Laptop", "Specs for Tablet", "Specs for Portable HDD",
            "Specs for Bluetooth Headphone", "Specs for Smart-watch: Compatibility - ios and Android | Water Resistance | Battery Life - 2days | GPS, fitness tracking, sleep monitoring, step counting, and more", "Specs for Digital Camera",
            "Specs for Portable Power bank", "Specs for Printer", "Specs for Wireless Router"
        };

        double[] costs = {
            1000.00, 1500.00, 800.00, 120.00, 50.00,
            300.00, 200.00, 80.00, 250.00, 100.00
        };

        int[] quantities = {
            100, 50, 80, 200, 150,
            25, 40, 100, 75, 60
        };

        boolean continueManagement = true;

   

        while (continueManagement) {
            System.out.println("1. View the complete list of our products");
            System.out.println("2. Check the available count for a specific product");
            System.out.println("3. View the specifications and details of a specific product");
            System.out.println("4. Modify the details of a specific product");
            System.out.println("5. Update the inventory for a specific product");
            System.out.println("6. Exit");
            System.out.print("Please choose an option from the above menu: ");
            int menuOption = input.nextInt();

            System.out.println("-----------------------------------------------------");

            switch (menuOption) {
                case 1:
                    displayProductList(productNames);
                    break;
                case 2:
                    System.out.print("Enter the Product ID: ");
                    int productId = input.nextInt();
                    displayProductCount(productId, productNames, quantities);
                    break;
                case 3:
                    System.out.print("Enter the Product ID: ");
                    productId = input.nextInt();
                    displayProductDetails(productId, productNames, specifications, quantities);
                    break;
                case 4:
                    System.out.print("Enter the Product ID: ");
                    productId = input.nextInt();
                    editProduct(productId, productNames, specifications, costs, quantities, input);
                    break;
                case 5:
                    System.out.print("Enter the Product ID: ");
                    productId = input.nextInt();
                    updateInventory(productId, quantities, input);
                    break;
                case 6:
                    continueManagement = false;
                    break;
                default:
                    System.out.println("Invalid menu option!");
            }

            System.out.println("-----------------------------------------------------");
            System.out.print("Enter \"Y\" to return to the main menu or \"N\" to Exit: ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("N")) {
                continueManagement = false;
            }

            System.out.println("-----------------------------------------------------");
        }

        System.out.println("Thank you for visiting SmartPoint!");

        input.close();
    }

    public static void displayProductList(String[] productNames) {
        System.out.println("List of all Products");
        System.out.println();
        System.out.println("Product ID   Product Name");
        for (int i = 0; i < productNames.length; i++) {
            System.out.printf("%10d   %s%n", (i + 101), productNames[i]);
        }
    }

    public static void displayProductCount(int productId, String[] productNames, int[] quantities) {
        if (productId >= 101 && productId <= (100 + productNames.length)) {
            int index = productId - 101;
            System.out.println(productId + productNames[index]);
            System.out.println("Total available count: " + quantities[index]);
        } else {
            System.out.println("Invalid product ID!");
        }
    }

    public static void displayProductDetails(int productId, String[] productNames,
                                              String[] specifications, int[] quantities) {
        if (productId >= 101 && productId <= (100 + productNames.length)) {
            int index = productId - 101;
            System.out.println(productId + productNames[index]);
            System.out.println("Total available count: " + quantities[index]);
            System.out.println("Specifications: " + specifications[index]);
        } else {
            System.out.println("Invalid product ID!");
        }
    }

    public static void editProduct(int productId, String[] productNames, String[] specifications,
                                    double[] costs, int[] quantities, Scanner input) {
        if (productId >= 101 && productId <= (100 + productNames.length)) {
            int index = productId - 101;
            System.out.println(productId + productNames[index]);
            System.out.print("Enter new specifications: ");
            specifications[index] = input.next();
            System.out.print("Enter new cost: $");
            costs[index] = input.nextDouble();
            System.out.print("Enter new quantity: ");
            quantities[index] = input.nextInt();
            System.out.println("Product details updated successfully!");
        } else {
            System.out.println("Invalid product ID!");
        }
    }

    public static void updateInventory(int productId, int[] quantities, Scanner input) {
        if (productId >= 101 && productId <= (100 + quantities.length)) {
            int index = productId - 101;
            int[] productNames;
            System.out.println(productId + productNames[index]);
            System.out.println("Current available inventory: " + quantities[index]);
            System.out.println("Add inventory");
            System.out.println("Subtract inventory");
            System.out.print("Please choose an option from the above menu: ");
            String option = input.next();

            if (option.equalsIgnoreCase("Add")) {
                System.out.print("Please enter the count to be added: ");
                int countToAdd = input.nextInt();
                quantities[index] += countToAdd;
                System.out.println(productId + productNames[index]);
                System.out.println("Total available count: " + quantities[index]);
            } else if (option.equalsIgnoreCase("Subtract")) {
                System.out.print("Please enter the count to be subtracted: ");
                int countToSubtract = input.nextInt();
                if (countToSubtract <= quantities[index]) {
                    quantities[index] -= countToSubtract;
                    System.out.println(productId + productNames[index]);
                    System.out.println("Total available count: " + quantities[index]);
                } else {
                    System.out.println("Insufficient quantity!");
                }
            } else {
                System.out.println("Invalid option!");
            }
        } else {
            System.out.println("Invalid product ID!");
        }
    }
}
