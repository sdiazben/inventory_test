package com.demo.inventory.service;


import com.demo.inventory.database.Inventory;
import com.demo.inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
public class InventoryService {

    @Autowired
    Inventory inventory;

    @Async("asyncExecutor")
    public Future<Item> findItemBySKU (int sku) {
        return new AsyncResult(inventory.findById(sku).get());
    }

    @Async("asyncExecutor")
    public void addOrUpdate (Item item){

        inventory.save(item);
    }

    @Async("asyncExecutor")
    public void delete (int sku)
    {
        inventory.deleteById(sku);
    }

    @Async("asyncExecutor")
    public Future<List<Item>> getInventory ()
    {
        List<Item> inv = new ArrayList<Item>();
        inventory.findAll().forEach(item -> inv.add(item));
        return new AsyncResult(inv);
    }

}
