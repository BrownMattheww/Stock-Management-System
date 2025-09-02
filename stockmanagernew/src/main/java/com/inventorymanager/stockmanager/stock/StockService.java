package com.inventorymanager.stockmanager.stock;

import com.inventorymanager.stockmanager.location.Location;
import com.inventorymanager.stockmanager.location.LocationRepository;
import com.inventorymanager.stockmanager.stockLocation.StockLocationDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final LocationRepository locationRepository;
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository, LocationRepository locationRepository) {
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock createStock(Stock stock) {
        Stock newStock = new Stock();
        newStock.setStockName(stock.getStockName());
        newStock.setStockPrice(stock.getStockPrice());
        return stockRepository.save(newStock);
    }

    public Stock updateStock(Long stockId, Stock stock) {
        Stock ammendedStock = new Stock();
        ammendedStock.setStockName(stock.getStockName());
        ammendedStock.setStockPrice(stock.getStockPrice());
        return stockRepository.save(ammendedStock);
    }

    public Stock deleteStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("No stock found with id " + stockId));

        stockRepository.delete(stock);
        return stock;
    }


}
