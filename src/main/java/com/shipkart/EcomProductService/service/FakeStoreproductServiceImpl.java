package com.shipkart.EcomProductService.service;

import com.shipkart.EcomProductService.client.FakeStoreAPIClient;
import com.shipkart.EcomProductService.dto.*;

import static com.shipkart.EcomProductService.mapper.ProductMapper.*;

import com.shipkart.EcomProductService.exceptions.ProductNotFoundException;
import com.shipkart.EcomProductService.model.Product;
import static com.shipkart.EcomProductService.util.ProductUtils.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreproductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreproductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList =
                fakeStoreAPIClient.getAllProducts();

        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for (FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOList){
            productListResponseDTO.getProductResponseDTOList().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }

        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductByID(int id) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductByID(id);
        if(isNull(fakeStoreProductResponseDTO)){
            throw new ProductNotFoundException("Product not available with ID : "+id);
        }
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(productRequestToFakeStoreProductRequest(productRequestDTO));
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductByID(id);
        if(isNull(fakeStoreProductResponseDTO)){
            throw new ProductNotFoundException("Product not available for deletion with id : "+id);
        }
        fakeStoreAPIClient.deleteProduct(id);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.updateProduct(id, productRequestToFakeStoreProductRequest(productRequestDTO));
        if(isNull(fakeStoreProductResponseDTO)){
            return createProduct(productRequestDTO);
        }
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }
}
