package com.promineotech.candle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.candle.entity.Order;
import com.promineotech.candle.entity.OrderRequest;
import com.promineotech.candle.service.CandleOrderService;

import jakarta.validation.Valid;


@RestController

//gets info from CandleOrderController and implements it
public class DefaultCandleOrderController implements CandleOrderController {
	
	@Autowired
	private CandleOrderService candleOrderService;
	@Override
	public Order createOrder(OrderRequest orderRequest) {
	return CandleOrderService.createOrder(orderRequest);
	}
	public CandleOrderService getCandleOrderService() {
		return candleOrderService;
	}
	public void setCandleOrderService(CandleOrderService candleOrderService) {
		this.candleOrderService = candleOrderService;
	}
	@Override
	public Order updateOrder(int customerPK, @Valid Order updatedOrder) {
		return CandleOrderService.updateOrder(customerPK, updatedOrder);
	}
	@Override
	public void deleteOrder(int deleteId) {
		
		
	}
	
  
}
