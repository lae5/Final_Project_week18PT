package com.promineotech.candle.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
	private Long orderPK;
	private Customer customer;
	//private Accessory accessory;
	private List<Option> options;
	private int quantity;
	  
	  @JsonIgnore
	  public Long getOrderPK() {
	    return orderPK;
	  }
	}

	  
	


