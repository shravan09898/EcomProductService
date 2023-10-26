package com.shipkart.EcomProductService.service;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import com.shipkart.EcomProductService.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductByID(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
