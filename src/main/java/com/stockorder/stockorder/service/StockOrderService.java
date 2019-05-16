package com.stockorder.stockorder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockorder.stockorder.dto.StockRequestDto;
import com.stockorder.stockorder.dto.UserRequestDto;
import com.stockorder.stockorder.entity.Quote;
import com.stockorder.stockorder.entity.Stock;
import com.stockorder.stockorder.entity.User;

@Service
public interface StockOrderService {

	public String addUser(UserRequestDto userRequestDto);

	public List<User> retUser();

	public String addStock(StockRequestDto stockRequestDto);

	public List<Stock> retStock();
	
	public Quote quote(long volume, long stockId);

}
