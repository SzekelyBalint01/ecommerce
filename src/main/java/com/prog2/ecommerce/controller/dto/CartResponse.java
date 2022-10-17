package com.prog2.ecommerce.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CartResponse {
    boolean added;

    public CartResponse() {

    }
}
