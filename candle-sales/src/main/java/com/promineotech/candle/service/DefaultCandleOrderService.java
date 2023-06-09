package com.promineotech.candle.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.candle.dao.CandleOrderDao;
import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Customer;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.Order;
import com.promineotech.candle.entity.OrderRequest;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;

@Service
public class DefaultCandleOrderService implements CandleOrderService {
	
	@Autowired
	private CandleOrderDao candleOrderDao;
	@Transactional
	
	public Order createOrder(OrderRequest orderRequest) {
	Customer customer = getCustomer(orderRequest);
	CandleType candle_type = getcandle_type(orderRequest);
	ScentName scent = getscent(orderRequest);
	SizeType size = getsize(orderRequest);
	List<Option> options = getOption(orderRequest);
	BigDecimal price = getPrice();
	for(Option option : options) {
	price.add(option.getPrice());
	}
	return CandleOrderDao.saveOrder(customer, candle_type, scent, size, price, options); }
	private BigDecimal getPrice() {
		
		return null;
	}
	/**
	* 
	* @paramorderRequest
	* @return
	*/
	List<Option> getOption(OrderRequest orderRequest) {
	return CandleOrderDao.fetchOptions(orderRequest.getOptions());
	}
	/**
	* 
	* @paramorderRequest
	* @return
	*/
	CandleType getcandle_type(OrderRequest orderRequest) {
	return CandleOrderDao.fetchCandleType(orderRequest.getCandle())
	.orElseThrow(() -> new NoSuchElementException(
	"Candle with ID=" + orderRequest.getCandle() + " was not found"));
	}
	/**
	* 
	* @paramorderRequest
	* @return
	*/
	ScentName getscent(OrderRequest orderRequest) {
	return CandleOrderDao.fetchScentName(orderRequest.getScent())
	.orElseThrow(() -> new NoSuchElementException(
	"Scent with ID=" + orderRequest.getScent() + " was not found"));
	}
	/**
	* 
	* @paramorderRequest
	* @return
	*/
	SizeType getsize(OrderRequest orderRequest) {
	return candleOrderDao.fetchSizeType(orderRequest.getSize())
	.orElseThrow(() -> new NoSuchElementException(
	"Size with ID=" + orderRequest.getSize() + " was not found"));
	}
	/**
	* 
	* @paramorderRequest
	* @return
	*/
	Customer getCustomer(OrderRequest orderRequest) {
	return CandleOrderDao.fetchCustomer(orderRequest.getCustomer())
	.orElseThrow(() -> new NoSuchElementException("Customer with ID="
	+ orderRequest.getCustomer() + " was not found"));

	}	

}
