package com.example.rest_iitu.classes;

public class Product {
    private String name;
    private String imageUrl;
    private String uriName;
    private String description;

    public Product(String name, String imageUrl, String uriName, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.uriName = uriName;
        this.description = description;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUriName() {
        return uriName;
    }

    public void setUriName(String uriName) {
        this.uriName = uriName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", uriName='" + uriName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
