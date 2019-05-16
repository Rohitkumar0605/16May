package com.stockorder.stockorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockorder.stockorder.dto.StockRequestDto;
import com.stockorder.stockorder.dto.UserRequestDto;
import com.stockorder.stockorder.entity.Quote;
import com.stockorder.stockorder.entity.Stock;
import com.stockorder.stockorder.entity.User;
import com.stockorder.stockorder.service.StockOrderServiceImpl;

@RestController
public class StockOrderController {

	@Autowired
	private StockOrderServiceImpl stockOrderServiceImpl;

	@PostMapping("/addUser")
	public String addUser(@RequestBody UserRequestDto userRequestDto) {
		return stockOrderServiceImpl.addUser(userRequestDto);
	}

	@GetMapping("/retrieveUsers")
	public List<User> retrieveUser() {
		return stockOrderServiceImpl.retUser();

	}

	@PostMapping("/addStock")
	public String addingStocks(@RequestBody StockRequestDto stockRequestDto) {
		return stockOrderServiceImpl.addStock(stockRequestDto);

	}

	@GetMapping("/retrieveStocks")
	public List<Stock> retrieveStocks() {
		return stockOrderServiceImpl.retStock();

	}

	@GetMapping("/getQuote/{volume}/{stockId}")
	public Quote getQuote(@PathVariable("volume") long volume, @PathVariable("stockId") long stockId) {
		return stockOrderServiceImpl.quote(volume,stockId);

	}

}
