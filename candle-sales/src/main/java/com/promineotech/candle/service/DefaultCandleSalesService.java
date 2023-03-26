package com.promineotech.candle.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.candle.dao.CandleSalesDao;
import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;


@Service
public class DefaultCandleSalesService implements CandleSalesService {

	
	@Autowired
	private CandleSalesDao candleSalesDao;
	@Override
	public List<Option> fetchOptions(CandleType candle, SizeType size, ScentName scent) {
		 
		    return candleSalesDao.fetchOptions(candle, size, scent);
	}

}
