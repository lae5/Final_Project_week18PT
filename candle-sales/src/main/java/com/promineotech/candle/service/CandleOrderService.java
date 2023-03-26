package com.promineotech.candle.service;

import com.promineotech.candle.entity.Order;
import com.promineotech.candle.entity.OrderRequest;

import jakarta.validation.Valid;

public interface CandleOrderService {

	   static Order createOrder(OrderRequest orderRequest) {
		
		return null;
	}

	static Order updateOrder(int customerPK, @Valid Order updatedOrder) {
		
		return null;
	}
	}


