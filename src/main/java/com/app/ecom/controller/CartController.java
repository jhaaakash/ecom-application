package com.app.ecom.controller;


import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestHeader("X-User-ID") String userId, @RequestBody CartItemRequest request)
        {
            if(!cartService.addToCart(userId, request))
            {
                    return ResponseEntity.badRequest().body("Product out of stock or User not fuond or Product not found.");
            }

        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
