package com.ijse.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ijse.pos.dto.ItemDto;
import com.ijse.pos.dto.StockDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.Stock;
import com.ijse.pos.service.ItemService;
import com.ijse.pos.service.StockService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController

 @CrossOrigin(origins="*")
public class StockController {
 @Autowired
    private StockService stockService;


 @GetMapping("/stocks")

     public List<Stock> getAllStocks(){
        
        return stockService.getAllStock();
    }

    
    @PostMapping("/stocks")

   // public Item createItem(@RequestBody  Item item ){
    //    return itemService.createItem(item);
   // }

    public Stock createStock(@RequestBody Stock stock){
    //     try{
    //     return ResponseEntity.status(201) .body(stockService.createStock(stockDto));
    // }catch(Exception e){
    //      return ResponseEntity.status(400) .body("Failed to create user");
    // }
    return stockService.createStock(stock);
     }
    


      @GetMapping("/stocks/{id}")

      public Stock getStockById(@PathVariable Long id){
     return stockService.findStockById(id);
     
    } 

    



     @PutMapping("/stocks/{id}")

    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock){
        return stockService.updateStock(id, stock);

    }
  
   // @DeleteMapping("/deleteitems/{id}")
    
  
    //public void deleteItem(@PathVariable("id") Long id){
       // itemService.deleteItem(id);

       

    //}
    
   
    @GetMapping("/categories/{id}/stocks")
    public ResponseEntity <List<Stock>> getstocks(@PathVariable Long id){
        return ResponseEntity.ok().body(stockService.getStocksByCategory(id));
       
    }
    



    
}
