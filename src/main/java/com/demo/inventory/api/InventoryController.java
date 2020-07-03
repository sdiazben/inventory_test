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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-02T21:11:49.357Z")

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public InventoryController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
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
        String accept = request.getHeader("Accept");
        inventoryService.delete(sku);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //GET BY SKU
    @GetMapping("/item/{sku}")
    public ResponseEntity<Item> findItemBySKU(@PathVariable("sku") int sku)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Item item = inventoryService.findItemBySKU(sku);
                return new ResponseEntity<Item>
                        (objectMapper.readValue("{  \"name\" : \""+item.getName()+"\", " +
                                        " \"count\" : "+item.getCount()+", " +
                                        " \"sku\" : \""+item.getSku()+"\"}",
                                Item.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
    }

    //UPDATE ITEM
    @PutMapping("/item/{sku}")
    public ResponseEntity<Item> updateItem(@RequestBody Item body)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                inventoryService.addOrUpdate(body);
                return new ResponseEntity<Item>
                        (objectMapper.readValue("{  \"name\" : \"" + body.getName() + "\", " +
                                        " \"count\" : " + body.getCount() + ", " +
                                        " \"sku\" : \"" + body.getSku() + "\"}",
                                Item.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
    }

    //GET ALL INVENTORY
    @GetMapping("/inventory")
    private List<Item> getInventory() {
        return inventoryService.getInventory();
    }

    //FIND ITEM BY NAME
    public ResponseEntity<Item> findItemByName(@RequestParam(value="name", required=true)  String name) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Item>(objectMapper.readValue("{  \"name\" : \"name\",  \"count\" : 0,  \"sku\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"}", Item.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
    }

}
