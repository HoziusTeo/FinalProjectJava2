package com.sda.app.controller;

import com.sda.app.entity.Cart;
import com.sda.app.entity.Item;
import com.sda.app.entity.User;
import com.sda.app.service.ItemService;
import com.sda.app.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllItems() {
        List<Item> itemList = this.itemService.findAll();
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item List successfully fetched")
                .data(itemList)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createItem(Item item) {
        itemService.deleteItem(item);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item successfully created")
                .data(itemService.createItem(item))
                .build();
        return ResponseEntity.ok(response);
    }


    @PatchMapping("/")
    public ResponseEntity<ApiResponse> updateItem(Item item) {
        itemService.deleteItem(item);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item successfully updated")
                .data(itemService.updateItem(item))
                .build();
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteItem(Item item) {
        itemService.deleteItem(item);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item successfully deleted")
                .data(null)
                .build();
        return ResponseEntity.ok(response);
    }
}
