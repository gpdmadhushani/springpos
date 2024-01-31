package com.ijse.pos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.StockDto;

import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.entity.Stock;
import com.ijse.pos.repository.ItemCategoryRepository;

import com.ijse.pos.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    
    private StockRepository stockRepository;
    @Autowired
    private ItemCategoryRepository categoryRepository;

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Stock createStock(Stock stock) {
       
       
         return stockRepository.save(stock);
         
           
      
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existingStock=stockRepository.findById(id).orElse(null);
      
        if(existingStock!=null){
        
          existingStock.setName(stock.getName());
          existingStock.setPrice(stock.getPrice());
         existingStock.setQuentity(stock.getQuentity());
         existingStock.setManufactered(stock.getManufactered());
         existingStock.setCategory_id(stock.getCategory_id());
          existingStock.setStatus(stock.getStatus());
          existingStock.setUpadtetime(stock.getUpadtetime());
        
        
         
         return stockRepository.save(existingStock);
        }else{
         return null;
        }






    }

    @Override
    public List<Stock> getStocksByCategory(Long id) {
        ItemCategory category=categoryRepository.findById(id).orElse(null);
        if(category!=null){
         
             return stockRepository.findStockByCategory(category);
        
        }else{
         return null;
        }
    }
    
}
