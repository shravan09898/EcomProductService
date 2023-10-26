package com.shipkart.EcomProductService.service;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import com.shipkart.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreproductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreproductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<ProductListResponseDTO> productResponse =
//                        restTemplate.getForEntity(getAllProductsURL, ProductListResponseDTO.class);
//        return productResponse.getBody();
        return null;
    }

    @Override
    public ProductResponseDTO getProductByID(int id) {
        String getAllProductsURL = "https://fakestoreapi.com/products/github"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse =
                        restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO.class);
        return productResponse.getBody();
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
