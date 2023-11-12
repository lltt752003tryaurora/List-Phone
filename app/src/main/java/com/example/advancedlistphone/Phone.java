package com.example.advancedlistphone;

public class Phone {
    // do ảnh nằm trong thư mục drawable. nằm trong res (bất kỳ cái j nằm trong thư mục res đều quản lý bằng id => các ảnh quản lý bằng id) => kiểu dữ liệu là int
    private int image;
    private String name;
    private String price;

    // tạo getter,setter
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // tạo constructor
    public Phone(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }
}
