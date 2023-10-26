package com.shipkart.EcomProductService.service;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import com.shipkart.EcomProductService.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductByID(int id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
