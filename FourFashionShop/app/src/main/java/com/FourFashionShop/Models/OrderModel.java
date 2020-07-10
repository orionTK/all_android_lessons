package com.FourFashionShop.Models;

public class OrderModel {
    private String productName, OrderId, OrderDate, Status;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public OrderModel(String productName, String orderId, String orderDate, String status) {
        this.productName = productName;
        OrderId = orderId;
        OrderDate = orderDate;
        Status = status;
    }
}
