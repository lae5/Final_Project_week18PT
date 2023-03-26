package com.promineotech.candle.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Option {
	private Long optionPK;
	private CandleType candle;
	private ScentName scent;
	private SizeType size;
	private BigDecimal price;

	@JsonIgnore  
	  public Long getOptionPk () {
	    return optionPK;
	  }
}
