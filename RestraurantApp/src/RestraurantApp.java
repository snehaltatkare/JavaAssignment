import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class MenuItem {
    private int menuId;
    private String name;
    private double price;

    public MenuItem(int menuId, String name, double price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
    }

    public int getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private static int orderIdCounter = 1;

    private int orderId;
    private List<MenuItem> items;
    private List<Integer> quantities;
    private double totalAmount;
    private String date;
    private String status;

    public Order(List<MenuItem> items, List<Integer> quantities) {
        this.orderId = orderIdCounter++;
        this.items = items;
        this.quantities = quantities;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.status = "Ordered";
        calculateTotalAmount();
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < items.size(); i++) {
            totalAmount += items.get(i).getPrice() * quantities.get(i);
        }
    }
}

class CollectionReport {
    private String date;
    private double totalCollection;

    public CollectionReport(String date, double totalCollection) {
        this.date = date;
        this.totalCollection = totalCollection;
    }

    public String getDate() {
        return date;
    }

    public double getTotalCollection() {
        return totalCollection;
    }
}

class RestaurantApp {
    private static List<MenuItem> menuItems = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static List<CollectionReport> collectionReports = new ArrayList<>();

    public static void main(String[] args) {
        initializeMenu();

        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        CollectionManager collectionManager = new CollectionManager();

        int choice;
        do {
            System.out.println("1. Place Order");
            System.out.println("2. Cancel Order");
            System.out.println("3. Daily Collection Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    orderManager.placeOrder();
                    break;
                case 2:
                    orderManager.cancelOrder();
                    break;
                case 3:
                    collectionManager.generateDailyCollectionReport();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void initializeMenu() {
        menuItems.add(new MenuItem(1, "Burger", 5.99));
        menuItems.add(new MenuItem(2, "Pizza", 8.99));
        menuItems.add(new MenuItem(3, "Salad", 3.99));
        // Add more menu items as needed
    }

    public static List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static List<CollectionReport> getCollectionReports() {
        return collectionReports;
    }
}

class OrderManager {
    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        List<MenuItem> menuItems = RestaurantApp.getMenuItems();
        List<Order> orders = RestaurantApp.getOrders();

        System.out.println("Available Menu Items:");
        for (MenuItem item : menuItems) {
            System.out.println(item.getMenuId() + ". " + item.getName() + " - $" + item.getPrice());
        }

        System.out.println("Enter the number of menu items to order: ");
        int itemCount = scanner.nextInt();
        List<MenuItem> items = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        for (int i = 0; i < itemCount; i++) {
            System.out.println("Enter Menu ID for item " + (i + 1) + ": ");
            int menuId = scanner.nextInt();
            MenuItem menuItem = getMenuById(menuId);

            if (menuItem != null) {
                items.add(menuItem);
                System.out.println("Enter quantity for item " + (i + 1) + ": ");
                int quantity = scanner.nextInt();
                quantities.add(quantity);
            } else {
                System.out.println("Invalid Menu ID. Please try again.");
                i--; // Repeat the loop iteration for the invalid input
            }
        }

        Order newOrder = new Order(items, quantities);
        orders.add(newOrder);

        System.out.println("Order placed successfully!");
    }

    public void cancelOrder() {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = RestaurantApp.getOrders();

        System.out.println("Enter the order ID to cancel: ");
        int orderIdToCancel = scanner.nextInt();

        Order orderToCancel = getOrderById(orderIdToCancel);

        if (orderToCancel != null) {
            orderToCancel.setStatus("Cancelled");
            System.out.println("Order cancelled successfully!");
        } else {
            System.out.println("Order not found. Please check the order ID and try again.");
        }
    }

    private MenuItem getMenuById(int menuId) {
        List<MenuItem> menuItems = RestaurantApp.getMenuItems();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getMenuId() == menuId) {
                return menuItem;
            }
        }
        return null;
    }

    private Order getOrderById(int orderId) {
        List<Order> orders = RestaurantApp.getOrders();
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}

class CollectionManager {
    public void generateDailyCollectionReport() {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = RestaurantApp.getOrders();
        List<CollectionReport> collectionReports = RestaurantApp.getCollectionReports();

        System.out.println("Enter the date for the collection report (yyyy-MM-dd): ");
        String date = scanner.next();

        double totalCollection = calculateTotalCollection(date, orders);

        CollectionReport report = new CollectionReport(date, totalCollection);
        collectionReports.add(report);

        System.out.println("Daily Collection Report for " + date + ":");
        System.out.println("Total Collection: $" + totalCollection);
    }

    private double calculateTotalCollection(String date, List<Order> orders) {
        double total = 0;
        for (Order order : orders) {
            if (order.getDate().equals(date) && order.getStatus().equals("Ordered")) {
                total += order.getTotalAmount();
            }
        }
        return total;
    }
}



