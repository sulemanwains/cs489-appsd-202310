package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

    public static void main(String[] args) {
        System.out.println("Hello CS489");
        var products = new Product[] { // Local variable type inference
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(3128874119L, "Apple", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(3128874119L, "Carrot", LocalDate.of(2023, 1, 24), 124, 0.55)
        };
        printProducts(products);
    }

    private static void printProducts(Product[] products) {
        if(products != null) {
            if(products.length > 0) {
                // Sort
//                Arrays.sort(products, new Comparator<Product>() {
//                    @Override
//                    public int compare(Product o1, Product o2) {
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                });
                // Streams API
                var sortedProducts = Arrays.stream(products)
//                        .sorted(Comparator.comparing(Product::getName));
                        .sorted(Comparator.comparing(p -> p.getName()))
                        .toList();
                // Print
                // JSON format
                var numProducts = sortedProducts.size();
                for (int i = 0; i < sortedProducts.size(); i++) {
                    if((i+1) < numProducts) {
                        System.out.printf("%s, \n", sortedProducts.get(i).toJSONString());
                    } else {
                        System.out.println(sortedProducts.get(i).toJSONString());
                    }
                }
            }
        }
    }
}
