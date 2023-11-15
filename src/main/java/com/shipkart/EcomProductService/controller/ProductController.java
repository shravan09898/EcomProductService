package com.shipkart.EcomProductService.controller;

import com.shipkart.EcomProductService.dto.ProductListResponseDTO;
import com.shipkart.EcomProductService.dto.ProductRequestDTO;
import com.shipkart.EcomProductService.dto.ProductResponseDTO;
import com.shipkart.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    //Field injection
//    @Autowired
//    @Qualifier("fakeStoreProductService")
//    private ProductService productServiceField;

    private final ProductService productService;
    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    //Get product of given ID
    @GetMapping("/products/{id}")
    public ResponseEntity getProductThroughID(@PathVariable("id") int id){
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
        ProductResponseDTO responseDTO = productService.getProductByID(id);
        return ResponseEntity.ok(responseDTO);
    }

    //Get all products
    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        ProductListResponseDTO responseDTO = productService.getAllProducts();
        return ResponseEntity.ok(responseDTO);
    }

    //Create a product
    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    //Delete a product

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable int id){
        ProductResponseDTO response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity updateProductById(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO response = productService.updateProduct(id,productRequestDTO);
        return ResponseEntity.ok(response);
    }
}
