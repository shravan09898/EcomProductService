package com.shipkart.EcomProductService.client;


import com.shipkart.EcomProductService.dto.FakeStoreProductDTO;
import com.shipkart.EcomProductService.dto.ProductRequestDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Wrapper on FakeStoreProduct APIs
 */
public class FakeStoreClient {
//    private String fakeStoreAPIUrl;
//    private String fakeStoreProductAPIPath;
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDTO createProduct(ProductRequestDTO productRequestDTO){
        String createProductURL = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> productResponseDTOResponseEntity =
                restTemplate.postForEntity(createProductURL, productRequestDTO, FakeStoreProductDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }
}
