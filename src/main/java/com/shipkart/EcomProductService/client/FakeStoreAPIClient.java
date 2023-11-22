package com.shipkart.EcomProductService.client;


import com.shipkart.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.shipkart.EcomProductService.dto.FakeStoreProductRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
    private String fakeStoreAPIURL;

    @Value("${fakestore.api.path.product}")  //Field injection
    private String fakeStoreAPIPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreAPIURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStorerProductRequestDTO){
        String createProductURL = fakeStoreAPIURL+fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.postForEntity(createProductURL, fakeStorerProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }

    public FakeStoreProductResponseDTO getProductByID(int id){
        String getProductURL = fakeStoreAPIURL+fakeStoreAPIPathProduct+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.getForEntity(getProductURL, FakeStoreProductResponseDTO.class);

        return productResponseDTOResponseEntity.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsURL = fakeStoreAPIURL+fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> responseEntityArray =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);

        return List.of(responseEntityArray.getBody());
    }

    public void deleteProduct(int id){
        String deleteProductURL = fakeStoreAPIURL+fakeStoreAPIPathProduct + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String updateProductURL = fakeStoreAPIURL+fakeStoreAPIPathProduct + id;
        HttpEntity<FakeStoreProductRequestDTO> entity = new HttpEntity<>(fakeStoreProductRequestDTO);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseDTOResponseEntity =
                restTemplate.exchange(updateProductURL, HttpMethod.PUT, entity, FakeStoreProductResponseDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }

}
