package com.sda.app.controller;

import com.sda.app.entity.Cart;
import com.sda.app.entity.Category;
import com.sda.app.entity.Item;
import com.sda.app.entity.User;
import com.sda.app.service.ItemService;
import com.sda.app.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/items")
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
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getItemById(@PathVariable("id")Integer id){
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item by ID")
                .data(itemService.findById(id))
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createItem(@RequestBody Item item) {
        Item it = new Item();
        it.setTitle(item.getTitle());
        it.setDescription(item.getDescription());
        it.setCategory(Category.valueOf(item.getCategory().toString()));
        System.out.println(item.getCategory());
        System.out.println(item.getTitle());
        System.out.println(item.getDescription());
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item successfully created")
                .data(itemService.createItem(item))
                .build();
        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> updateItem(@RequestBody Item item,@PathVariable("id")Integer id) {
        System.out.println(id);
        Item it = new Item();
        it.setId(item.getId());
        it.setTitle(item.getTitle());
        it.setDescription(item.getDescription());
        it.setCategory(Category.valueOf(item.getCategory().toString()));
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item successfully updated")
                .data(itemService.updateItem(item))
                .build();
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable("id")Integer id) {
        itemService.deleteItem(id);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Item successfully deleted")
                .data(null)
                .build();
        return ResponseEntity.ok(response);
    }
}
