package com.demo.inventory.database;
import com.demo.inventory.model.Item;
import org.springframework.data.repository.CrudRepository;


public interface Inventory extends CrudRepository<Item, Integer> {
}
