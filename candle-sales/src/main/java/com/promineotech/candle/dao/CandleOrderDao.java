package com.promineotech.candle.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Customer;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.Order;
import com.promineotech.candle.entity.OrderRequest;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;




public interface CandleOrderDao {
    
	
	Order createOrder(OrderRequest orderRequest);

	  static List<Option> fetchOptions(List<String> optionIds) {
		
		return null;
	}
	  static Optional<Customer> fetchCustomer(String customerId) {
		
		return null;
	}
	  static Optional<CandleType> fetchCandleType(CandleType candleId) {
		
		return null;
	}
	  static Optional<ScentName> fetchScentName(ScentName scentId) {
		
		return null;
	}
	  Optional<SizeType> fetchSizeType(SizeType sizeId);
	  	  
	  
	  static Order saveOrder(Customer customer, CandleType candle, ScentName scent, SizeType size,  
	      BigDecimal price, List<Option> options) {
		
		return null;
	}

	
	}

	


