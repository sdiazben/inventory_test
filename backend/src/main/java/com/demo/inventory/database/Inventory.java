package com.demo.inventory.database;
import com.demo.inventory.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface Inventory extends CrudRepository<Item, Integer> {
}
