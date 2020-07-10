package com.FourFashionShop.Models;

public class CartModel {
    private String name;
    int totalPrice, txtSoLuong;
    private int img;


    public CartModel(String name, int totalPricae, int img, int txtSoLuong) {
        this.name = name;
        this.totalPrice = totalPricae;
        this.img = img;
        this.txtSoLuong = txtSoLuong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getTxtSoLuong() {
        return txtSoLuong;
    }

    public void setTxtSoLuong(int txtSoLuong) {
        this.txtSoLuong = txtSoLuong;
    }
}
