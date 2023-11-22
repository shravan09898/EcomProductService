package com.shipkart.EcomProductService.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ECOM_CATEGORY")
public class Category extends BaseModel{
    private String categoryName;
}
