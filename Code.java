import java.util.*;

class Product {
    private int id, quantity;
    private String name, category;
    private double price;

    Product(int id, String name, String category,
            double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    int getId() {
        return id;
    }

    void update(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + "  " + name + "  " +
            category + "  Rs." + price + "  " + quantity);
    }
}

class ProductManager {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        for (Product x : products) {
            if (x.getId() == p.getId()) {
                System.out.println("ID already exists!");
                return;
            }
        }
        products.add(p);
        System.out.println("Product Added Successfully!");
    }

    void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No Products Found!");
            return;
        }

        System.out.println("ID  Name  Category  Price  Quantity");
        for (Product p : products) {
            p.display();
        }
    }

    void searchProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.display();
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    void updateProduct(int id, double price, int qty) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.update(price, qty);
                System.out.println("Updated Successfully!");
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    void deleteProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("Deleted Successfully!");
                return;
            }
        }
        System.out.println("Product Not Found!");
    }
}

public class Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager pm = new ProductManager();

        while (true) {
            System.out.println("\n===== E-COMMERCE PRODUCT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    pm.addProduct(new Product(
                        id, name, category, price, qty));
                    break;

                case 2:
                    pm.displayProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    pm.searchProduct(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    price = sc.nextDouble();

                    System.out.print("Enter New Quantity: ");
                    qty = sc.nextInt();

                    pm.updateProduct(id, price, qty);
                    break;

                case 5:
                    System.out.print("Enter Product ID: ");
                    pm.deleteProduct(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
