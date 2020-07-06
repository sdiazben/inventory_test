package com.demo.inventory.api;

import java.util.UUID;

import com.demo.inventory.model.Item;
import com.demo.inventory.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-02T21:11:49.357Z")

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);


    //GET ALL ITEMS
    @GetMapping("/item")
    private List<Item> getInventory() {
        try {
            return inventoryService.getInventory().get();
        } catch (InterruptedException e) {
            log.error("Couldn't serialize response for content type application/json", e);
        } catch (ExecutionException e) {
            log.error("Couldn't serialize response for content type application/json", e);
        }
        return null;
    }

    //POST
    @PostMapping("/item")
    public int addItem(@RequestBody Item body)
    {
        try {
            inventoryService.addOrUpdate(body);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
        }
        return body.getSku();
    }

    //DELETE
    @DeleteMapping("/item/{sku}")
    public ResponseEntity<Void> deleteItem(@PathVariable("sku") int sku) {
        inventoryService.delete(sku);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //GET BY SKU
    @GetMapping("/item/{sku}")
    public Item findItemBySKU(@PathVariable("sku") int sku)
    {
        try {
            return inventoryService.findItemBySKU(sku).get();
        } catch (InterruptedException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        } catch (ExecutionException e) {
        log.error("Couldn't serialize response for content type application/json", e);
    }
        return null;
    }

    //UPDATE ITEM
    @PutMapping("/item/{sku}")
    public Item updateItem(@RequestBody Item body)
    {
        try {
            inventoryService.addOrUpdate(body);
            return body;
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return null;
        }
    }




}
