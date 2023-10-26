package com.shipkart.EcomProductService.controller;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import com.shipkart.EcomProductService.model.Product;
import com.shipkart.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @GetMapping("/products/1")
    public ResponseEntity getProductThroughID(){
        /*
        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("MacBook Pro");
        p1sca.setPrice(250000);
        p1.setImage("https://images.app.goo.gl/EybMikQpijM7Y47BA");
        p1.setDescription("expensive laptop");
        p1.setCategory("Electronics");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Iphone 15");
        p2.setPrice(80000);
        p2.setImage("https://images.app.goo.gl/EybMikQpijM7Y47BA");
        p2.setDescription("expensive phone");
        p2.setCategory("Electronics");

        List<ProductResponseDTO> productsList = Arrays.asList(p1,p2);

        return ResponseEntity.ok(productsList);
         */
        ProductResponseDTO responseDTO = productService.getProductByID(1);
        return ResponseEntity.ok(responseDTO);
    }
}
