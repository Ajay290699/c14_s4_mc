package com.niit.C13_s5_pc.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Customer {

    @Id
    private int customerId;
    private String customerName;
    private long customerPhoneNo;
    private Product customerProduct;

    public Customer() {
    }

    public Customer(int customerId, String customerName, long customerPhoneNo, Product customerProduct) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.customerProduct = customerProduct;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(long customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public Product getCustomerProduct() {
        return customerProduct;
    }

    public void setCustomerProduct(Product customerProduct) {
        this.customerProduct = customerProduct;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNo=" + customerPhoneNo +
                ", customerProduct=" + customerProduct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && customerPhoneNo == customer.customerPhoneNo && Objects.equals(customerName, customer.customerName) && Objects.equals(customerProduct, customer.customerProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerPhoneNo, customerProduct);
    }
}