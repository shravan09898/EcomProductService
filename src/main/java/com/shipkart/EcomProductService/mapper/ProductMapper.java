package com.shipkart.EcomProductService.mapper;

import com.shipkart.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.shipkart.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.shipkart.EcomProductService.dto.ProductRequestDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;

public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDTO fakeStorerProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStorerProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStorerProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStorerProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStorerProductRequestDTO.setImage(productRequestDTO.getImage());
        fakeStorerProductRequestDTO.setTitle(productRequestDTO.getTitle());

        return fakeStorerProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());

        return productResponseDTO;
    }
}
