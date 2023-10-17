package org.example;
import org.example.model.Product;
import org.example.model.Supplier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // Initialize suppliers and products
        List<Supplier> suppliers = initializeSuppliers();

        // Find and display star suppliers
        List<Supplier> starSuppliers = findStarSuppliers(suppliers);
        displayStarSuppliers(starSuppliers);
    }

    private static List<Supplier> initializeSuppliers() {
        // Sample data for suppliers and products
        Supplier google = new Supplier(1, "Google, Inc.", null, Arrays.asList(
                new Product(3128874119L, "Pixel 8 Pro", "2023-01-24", 124, new BigDecimal("1599.55"), null)
        ));

        Supplier apple = new Supplier(2, "Apple, Inc.", "(641) 123-0987", Arrays.asList(
                new Product(2927458265L, "iPad 14 Pro", "2022-12-09", 18, new BigDecimal("1700.09"), null),
                new Product(2927458266L, "iPhone 15", "2023-10-11", 95, new BigDecimal("1650.85"), null)
        ));

        Supplier samsung = new Supplier(3, "Samsung Corporation", null, null);

        Supplier huawei = new Supplier(4, "Huawei", null, null);

        return Arrays.asList(google, apple, samsung, huawei);
    }

    private static List<Supplier> findStarSuppliers(List<Supplier> suppliers) {
        List<Supplier> starSuppliers = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            if (supplier.isStarSupplier()) {
                starSuppliers.add(supplier);
            }
        }
        return starSuppliers;
    }

    private static void displayStarSuppliers(List<Supplier> starSuppliers) {
        for (Supplier starSupplier : starSuppliers) {
            System.out.println("Star Supplier: " + starSupplier.getName());

            List<Product> products = starSupplier.getProducts();
            for (Product product : products) {
                System.out.println("  Product: " + product.getName() +
                        ", Quantity: " + product.getQuantitySupplied() +
                        ", Total Value: $" + product.getTotalValue());
            }
        }
    }

}


