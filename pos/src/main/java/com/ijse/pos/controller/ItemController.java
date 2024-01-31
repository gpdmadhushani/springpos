package com.ijse.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ijse.pos.dto.ItemDto;
import com.ijse.pos.entity.Item;

import com.ijse.pos.service.ItemService;

@RestController

 @CrossOrigin(origins="*")
public class ItemController {
    @Autowired
    private ItemService itemService;


 @GetMapping("/items")

     public List<Item> getAllItems(){
        
        return itemService.getAllItems();
    }

    
    @PostMapping("/items")

   // public Item createItem(@RequestBody  Item item ){
    //    return itemService.createItem(item);
   // }

    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
     }
    


      @GetMapping("/items/{id}")

      public Item getItemById(@PathVariable Long id){
     return itemService.findItemById(id);
     
    } 

    



     @PutMapping("/items/{id}")

    public Item updateItem(@PathVariable Long id, @RequestBody Item item){
        return itemService.updateItem(id, item);

    }
  
    @DeleteMapping("/deleteitems/{id}")
    
  
    public void deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);

       

    }
    
   
    @GetMapping("/categories/{id}/items")
    public ResponseEntity <List<Item>> getitems(@PathVariable Long id){
        return ResponseEntity.ok().body(itemService.getItemsByCategory(id));
       
    }
    





}
