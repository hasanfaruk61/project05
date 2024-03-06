package com.demo.project05.entitydto;

public class CreateProductRequestDTO {

    private String name;
    private String category;
    private String photoUrl;
    private String description;
    private Double price;

    public CreateProductRequestDTO() {
    }

    public CreateProductRequestDTO(String name, String category, String photoUrl, String description, double price) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
