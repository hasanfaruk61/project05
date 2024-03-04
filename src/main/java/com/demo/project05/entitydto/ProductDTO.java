package com.demo.project05.entitydto;

public class ProductDTO {
    private String name;
    private String category;
    private String photoUrl;
    private String description;
    private String price;

    public ProductDTO() {
    }

    public ProductDTO(String name, String category, String photoUrl, String description, String price) {
        this.name = name;
        this.category = category;
        this.photoUrl = photoUrl;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
