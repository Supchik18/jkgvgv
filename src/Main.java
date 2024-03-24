import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;
import java.util.Arrays;

class Main {
    private static List<String> firms = Arrays.asList("Часы");
    private static String[][] items = {
            {"Rolex", "Omega", "Cartier"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.print("Введите количество заказов: ");
        int numOfOrders = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        for (int i = 0; i < numOfOrders; i++) {
            System.out.println("Заказ #" + (i + 1));
            System.out.print("Введите ФИО покупателя: ");
            String fullName = scanner.nextLine();
            System.out.print("Введите email покупателя: ");
            String email = scanner.nextLine();
            System.out.print("Введите номер телефона покупателя: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Выберите позицию товара:");
            printItems();
            System.out.print("Введите номер марки: ");
            int brandIndex = scanner.nextInt();
            System.out.print("Введите количество товара: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода чисел
            Order order = new Order(fullName, email, phoneNumber, firms, items, 0, brandIndex - 1, quantity);
            if (!orders.contains(order)) {
                orders.add(order);
            }
        }

        System.out.println("Итоговые заказы:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private static void printItems() {
        System.out.println(firms.get(0));
        for (int j = 0; j < items[0].length; j++) {
            System.out.println((j + 1) + ". " + items[0][j]);
        }
    }
}

class Order {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String firm;
    private String brand;
    private int quantity;

    public Order(String fullName, String email, String phoneNumber, List<String> firms, String[][] items, int firmIndex, int brandIndex, int quantity) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firm = firms.get(firmIndex);
        this.brand = items[firmIndex][brandIndex];
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return fullName.equals(order.fullName) && email.equals(order.email) &&
                phoneNumber.equals(order.phoneNumber) && firm.equals(order.firm) &&
                brand.equals(order.brand) && quantity == order.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, phoneNumber, firm, brand, quantity);
    }

    @Override
    public String toString() {
        return "Покупатель: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "Телефон: " + phoneNumber + "\n" +
                "Позиция товара: " + firm + " - " + brand + "\n" +
                "Количество: " + quantity + "\n";
    }
}
