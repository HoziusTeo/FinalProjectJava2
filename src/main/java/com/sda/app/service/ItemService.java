package com.sda.app.service;

import com.sda.app.entity.Cart;
import com.sda.app.entity.Item;
import com.sda.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }
    public Optional<Item> findById(Integer id){
        return itemRepository.findById(id);
    }
    public Item createItem(Item item){
        return itemRepository.save(item);
    }
    public Item updateItem(Item item){
        return itemRepository.save(item);
    }
    public void deleteItem(Item item){
        itemRepository.delete(item);
    }
}
