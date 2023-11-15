package com.shipkart.EcomProductService.client;


import com.shipkart.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.shipkart.EcomProductService.dto.FakeStoreProductRequestDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Wrapper on FakeStoreProduct APIs
 */
@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStorerProductRequestDTO){
        String createProductURL = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.postForEntity(createProductURL, fakeStorerProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }

    public FakeStoreProductResponseDTO getProductByID(int id){
        String getProductURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.getForEntity(getProductURL, FakeStoreProductResponseDTO.class);

        return productResponseDTOResponseEntity.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsURL = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> responseEntityArray =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);

        return List.of(responseEntityArray.getBody());
    }

    public void deleteProduct(int id){
        String deleteProductURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreProductRequestDTO fakeStorerProductRequestDTO){
        String updateProductURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.postForEntity(updateProductURL, fakeStorerProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }

}
