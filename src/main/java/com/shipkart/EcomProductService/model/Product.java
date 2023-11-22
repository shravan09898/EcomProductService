package com.shipkart.EcomProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ECOM_PRODUCT")
public class Product extends BaseModel{
    private String title;
    private double price;

    @ManyToOne
    private Category category;
    private String description;
    private String image;
}
