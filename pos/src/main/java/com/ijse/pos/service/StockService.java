package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.dto.ItemDto;
import com.ijse.pos.dto.StockDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStock();
    Stock findStockById(Long id);
    Stock createStock(Stock stock);
    Stock updateStock(Long id,Stock stock); 
    List<Stock> getStocksByCategory(Long id);


}
