package com.example.waterpurifier.ui.home;

public class Contac_MayLocNuoc {

    private String price;
    private String image;
    private String name_product;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Contac_MayLocNuoc(String price, String image, String name_product) {
        this.price = price;
        this.image = image;
        this.name_product = name_product;
    }
}