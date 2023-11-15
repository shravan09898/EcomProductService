package com.shipkart.EcomProductService.service;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductRequestDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import com.shipkart.EcomProductService.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductByID(int id);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO deleteProduct(int id);
    ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO);
}
