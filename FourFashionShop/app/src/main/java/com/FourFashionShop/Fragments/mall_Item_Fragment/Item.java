package com.FourFashionShop.Fragments.mall_Item_Fragment;

public class Item {
    private String Title;
    private String Price;
    private String SoLuong;
    private int Img;

    public Item() {
    }

    public Item(String title, String price, String soLuong, int img) {
        Title = title;
        Price = price;
        SoLuong = soLuong;
        Img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
