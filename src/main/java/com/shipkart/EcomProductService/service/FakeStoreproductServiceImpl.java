package com.shipkart.EcomProductService.service;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductRequestDTO;
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
        ResponseEntity<ProductResponseDTO[]> productResponseArray =
                        restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO[].class);

        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        for(ProductResponseDTO productResponse : productResponseArray.getBody()){
            responseDTO.getProductResponseDTOList().add(productResponse);
        }
        return responseDTO;
    }

    @Override
    public ProductResponseDTO getProductByID(int id) {
        String getProductURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse =
                        restTemplate.getForEntity(getProductURL, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String createProductURL = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.postForEntity(createProductURL, productRequestDTO, ProductResponseDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) {
        String deleteProductURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse =
                restTemplate.getForEntity(deleteProductURL, ProductResponseDTO.class);
        restTemplate.delete(deleteProductURL);
        return productResponse.getBody();
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
