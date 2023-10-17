package org.example.model;
import java.util.List;

import java.util.List;
public class Supplier {
    private long supplierId;
    private String name;
    private String contactPhone;
    private List<Product> products; // Add products attribute

    public Supplier(long supplierId, String name, String contactPhone, List<Product> products) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPhone = contactPhone;
        this.products = products;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Add the getTotalValueOfProducts method
    public double getTotalValueOfProducts() {
        double totalValue = 0;
        if (products != null) {
            for (Product product : products) {
                totalValue += product.getTotalValue().doubleValue();
            }
        }
        return totalValue;
    }

    // Add the isStarSupplier method
    public boolean isStarSupplier() {
        int productCount = 0;
        double totalValue = 0;

        if (products != null) {
            for (Product product : products) {
                productCount++;
                totalValue += product.getTotalValue().doubleValue();
            }
        }

        return productCount >= 2 && totalValue > 100000;
    }
}


