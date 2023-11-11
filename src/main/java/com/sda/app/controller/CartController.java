package com.sda.app.controller;

import com.sda.app.entity.Cart;
import com.sda.app.entity.Item;
import com.sda.app.service.CartService;
import com.sda.app.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllCarts() {
        List<Cart> cartList = this.cartService.findAll();
            ApiResponse response = new ApiResponse.Builder()
                    .status(200)
                    .message("Cart List successfully fetched")
                    .data(cartList)
                    .build();
            return ResponseEntity.ok(response);
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createItem(Cart cart){
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Cart successfully created")
                .data(cartService.createCart(cart))
                .build();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/")
    public ResponseEntity<ApiResponse> updateCart(Cart cart){
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Cart successfully updated")
                .data(cartService.updateCart(cart))
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteCart(Cart cart) {
        cartService.deleteCart(cart);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Cart successfully deleted")
                .data(null)
                .build();
        return ResponseEntity.ok(response);
    }

}