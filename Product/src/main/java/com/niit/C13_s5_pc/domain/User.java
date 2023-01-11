package com.niit.C13_s5_pc.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class User {

    @Id
    private int userId;
    private String userName;
    private long userPhoneNo;
    private Product userProduct;

    public User() {
    }

    public User(int userId, String userName, long userPhoneNo, Product userProduct) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNo = userPhoneNo;
        this.userProduct = userProduct;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int customerId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(long userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public Product getUserProduct() {
        return userProduct;
    }

    public void setUserProduct(Product userProduct) {
        this.userProduct = userProduct;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhoneNo=" + userPhoneNo +
                ", userProduct=" + userProduct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userPhoneNo == user.userPhoneNo && Objects.equals(userName, user.userName) && Objects.equals(userProduct, user.userProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPhoneNo, userProduct);
    }
}