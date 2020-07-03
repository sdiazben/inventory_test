package com.demo.inventory.service;


import com.demo.inventory.database.Inventory;
import com.demo.inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InventoryService {

    @Autowired
    Inventory inventory;

    public Item findItemBySKU (int sku) {

        return inventory.findById(sku).get();
    }
    
    public void addOrUpdate (Item item){
        inventory.save(item);
    }

    public void delete (int sku) {
        inventory.deleteById(sku);
    }

    public List<Item> getInventory ()
    {
        List<Item> inv = new ArrayList<Item>();
        inventory.findAll().forEach(item -> inv.add(item));
        return inv;
    }

}
