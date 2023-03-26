package com.promineotech.candle.service;

import java.util.List;

import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;

public interface CandleSalesService {

	List<Option> fetchOptions(CandleType candle, SizeType size, ScentName scent);

}
