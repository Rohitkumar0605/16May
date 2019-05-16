package com.stockorder.stockorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockorder.stockorder.dto.StockRequestDto;
import com.stockorder.stockorder.dto.UserRequestDto;
import com.stockorder.stockorder.entity.Quote;
import com.stockorder.stockorder.entity.Stock;
import com.stockorder.stockorder.entity.User;
import com.stockorder.stockorder.repository.QuoteRepository;
import com.stockorder.stockorder.repository.StockRepository;
import com.stockorder.stockorder.repository.UserRepository;

@Service
public class StockOrderServiceImpl implements StockOrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private QuoteRepository quoteRepository;

	@Override
	public String addUser(UserRequestDto userRequestDto) {
		User user = new User();

		User u1 = userRepository.findByUserId(userRequestDto.getUserId());

		if (u1 != null) {
			return "Validate based on the used ID existing";
		} else {

			user.setUserId(userRequestDto.getUserId());
			user.setName(userRequestDto.getName());
			user.setAddress(userRequestDto.getAddress());
			user.setMail(userRequestDto.getMail());
			user.setMobileNumber(userRequestDto.getMobileNumber());

			userRepository.save(user);
			return user.getName() + "Stock Successfully Added";

		}

	}

	@Override
	public List<User> retUser() {
		return userRepository.findAll();
	}

	@Override
	public String addStock(StockRequestDto stockRequestDto) {
		Stock stock = new Stock();

		Stock st1 = stockRepository.findByStockId(stockRequestDto.getStockId());

		if (st1 != null) {
			return "Validate based on the used ID existing";
		} else {
			stock.setStockId(stockRequestDto.getStockId());
			stock.setStockName(stockRequestDto.getStockName());
			stock.setStockPrice(stockRequestDto.getStockPrice());

			stockRepository.save(stock);
			return stockRequestDto.getStockName() + "Stock Successfully Added";

		}
	}

	@Override
	public List<Stock> retStock() {
		return stockRepository.findAll();
	}

	@Override
	public Quote quote(long volume, long stockId) {
		Quote q1 = new Quote();

		Stock st1 = stockRepository.findByStockId(stockId);
		q1.setPurchasePrice(volume * st1.getStockPrice());
		q1.setStockId(st1.getStockId());
		q1.setStockName(st1.getStockName());
		q1.setVolume(volume);
		q1.setPrice(st1.getStockPrice());

		if (volume < 500) {
			q1.setFee(0.10 * (q1.getPurchasePrice()));
		} else {
			Long v1 = volume - 500;
			q1.setFee((500 * st1.getStockPrice() * 0.10) + (v1 * st1.getStockPrice() * 0.15));
		}

		q1.setTotalFee(q1.getPurchasePrice() + q1.getFee());
		q1.setWarning("Stock prices are not fixed it will change time to time");
		quoteRepository.save(q1);

		return q1;
	}

}
