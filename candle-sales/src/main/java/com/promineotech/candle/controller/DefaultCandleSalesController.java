package com.promineotech.candle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;
import com.promineotech.candle.service.CandleSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
//have to tell Springboot that this controller is a rest controller
//not done in interface done in class
@Slf4j
public class DefaultCandleSalesController implements CandleSalesController {
	@Autowired
	private CandleSalesService candleSalesService;
	
	public List<Option> fetchOptions(CandleType candle, 
			SizeType size, ScentName scent) {
		
	    log.info("candle_type={}, size_type{}, scent_name{}, candle, size, scent");
	    return candleSalesService.fetchOptions(candle, size, scent);

	}
}
