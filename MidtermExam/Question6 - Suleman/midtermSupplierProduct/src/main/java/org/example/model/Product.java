package org.example.model;
import java.math.BigDecimal;


public class Product {
    private long productNo;
    private String name;
    private String dateSupplied;
    private int quantitySupplied;
    private BigDecimal unitPrice;
    private Supplier supplier; // Add supplier attribute

    public Product(long productNo, String name, String dateSupplied, int quantitySupplied, BigDecimal unitPrice, Supplier supplier) {
        this.productNo = productNo;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantitySupplied = quantitySupplied;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
    }

    public long getProductNo() {
        return productNo;
    }

    public String getName() {
        return name;
    }

    public String getDateSupplied() {
        return dateSupplied;
    }

    public int getQuantitySupplied() {
        return quantitySupplied;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public BigDecimal getTotalValue() {
        return unitPrice.multiply(BigDecimal.valueOf(quantitySupplied));
    }
}



