
import java.util.ArrayList;
        import java.util.Scanner;

class Product {
    private String productName;
    private String productSpecification;
    private double productCost;
    private int productCount;

    // Constructor
    public Product(String productName, String productSpecification, double productCost, int productCount) {
        this.productName = productName;
        this.productSpecification = productSpecification;
        this.productCost = productCost;
        this.productCount = productCount;
    }

    // Getter and Setter methods
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product Specification: " + productSpecification);
        System.out.println("Product Cost: $" + productCost);
        System.out.println("Product Count: " + productCount);
    }
}

class InventoryManager {
    private ArrayList<Product> productList;

    // Constructor
    public InventoryManager() {
        productList = new ArrayList<>();
    }

    // Method to add a new product to the inventory
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added to inventory.");
    }

    // Method to remove a product from the inventory
    public void removeProduct(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productList.remove(product);
                System.out.println("Product removed from inventory.");
                return;
            }
        }
        System.out.println("Product not found in inventory.");
    }

    // Method to display the list of all products
    public void viewProductList() {
        System.out.println("Product List:");
        for (Product product : productList) {
            System.out.println(product.getProductName());
        }
    }

    // Method to view the count of a specific product
    public void viewProductCount(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("Product Count for " + productName + ": " + product.getProductCount());
                return;
            }
        }
        System.out.println("Product not found in inventory.");
    }

    // Method to view details of a specific product
    public void viewProductDetails(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.displayProductDetails();
                return;
            }
        }
        System.out.println("Product not found in inventory.");
    }

    // Method to edit product details
    public void editProductDetails(String productName, String newSpecification, double newCost) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.setProductSpecification(newSpecification);
                product.setProductCost(newCost);
                System.out.println("Product details updated successfully.");
                return;
            }
        }
        System.out.println("Product not found in inventory.");
    }

    // Method to update inventory (add or delete product quantities)
    public void updateInventory(String productName, int quantity) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                int currentCount = product.getProductCount();
                int newCount = currentCount + quantity;

                if (newCount >= 0) {
                    product.setProductCount(newCount);
                    System.out.println("Inventory updated successfully.");
                } else {
                    System.out.println("Insufficient quantity to remove from inventory.");
                }
                return;
            }
        }
        System.out.println("Product not found in inventory.");
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();

        int choice;
        do {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Product List");
            System.out.println("4. View Product Count");
            System.out.println("5. View Product Details");
            System.out.println("6. Edit Product Details");
            System.out.println("7. Update Inventory");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner, inventoryManager);
                    break;
                case 2:
                    removeProduct(scanner, inventoryManager);
                    break;
                case 3:
                    inventoryManager.viewProductList();
                    break;
                case 4:
                    viewProductCount(scanner, inventoryManager);
                    break;
                case 5:
                    viewProductDetails(scanner, inventoryManager);
                    break;
                case 6:
                    editProductDetails(scanner, inventoryManager);
                    break;
                case 7:
                    updateInventory(scanner, inventoryManager);
                    break;
                case 8:
                    System.out.println("Exiting the Inventory Management System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }

    private static void addProduct(Scanner scanner, InventoryManager inventoryManager) {
        System.out.print("Enter Product Name: ");
        String productName = scanner.next();
        System.out.print("Enter Product Specification: ");
        String productSpecification = scanner.next();
        System.out.print("Enter Product Cost: ");
        double productCost = scanner.nextDouble();
        System.out.print("Enter Product Count: ");
        int productCount = scanner.nextInt();

        Product newProduct = new Product(productName, productSpecification, productCost, productCount);
        inventoryManager.addProduct(newProduct);
    }

    private static void removeProduct(Scanner scanner, InventoryManager inventoryManager) {
        System.out.print("Enter Product Name to remove: ");
        String productNameToRemove = scanner.next();
        inventoryManager.removeProduct(productNameToRemove);
    }

    private static void viewProductCount(Scanner scanner, InventoryManager inventoryManager) {
        System.out.print("Enter Product Name to view count: ");
        String productNameToViewCount = scanner.next();
        inventoryManager.viewProductCount(productNameToViewCount);
    }

    private static void viewProductDetails(Scanner scanner, InventoryManager inventoryManager) {
        System.out.print("Enter Product Name to view details: ");
        String productNameToViewDetails = scanner.next();
        inventoryManager.viewProductDetails(productNameToViewDetails);
    }

    private static void editProductDetails(Scanner scanner, InventoryManager inventoryManager) {
        System.out.print("Enter Product Name to edit details: ");
        String productNameToEdit = scanner.next();
        System.out.print("Enter new Product Specification: ");
        String newSpecification = scanner.next();
        System.out.print("Enter new Product Cost: ");
        double newCost = scanner.nextDouble();

        inventoryManager.editProductDetails(productNameToEdit, newSpecification, newCost);
    }

    private static void updateInventory(Scanner scanner, InventoryManager inventoryManager) {
        System.out.print("Enter Product Name to update inventory: ");
        String productNameToUpdate = scanner.next();
        System.out.print("Enter quantity to add/delete (positive to add, negative to delete): ");
        int quantity = scanner.nextInt();

        inventoryManager.updateInventory(productNameToUpdate, quantity);
    }
}

