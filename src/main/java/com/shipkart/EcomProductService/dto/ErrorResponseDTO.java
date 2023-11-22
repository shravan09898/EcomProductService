package com.shipkart.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {
    String errorMessage;
    int errorCode;
}
