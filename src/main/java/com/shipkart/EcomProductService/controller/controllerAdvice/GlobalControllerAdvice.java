package com.shipkart.EcomProductService.controller.controllerAdvice;

import com.shipkart.EcomProductService.dto.ErrorResponseDTO;
import com.shipkart.EcomProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage(e.getMessage());
        errorResponseDTO.setErrorCode(404);

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

}
