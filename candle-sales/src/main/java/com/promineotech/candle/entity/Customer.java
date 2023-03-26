package com.promineotech.candle.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
	private Long customerPK;
	private String firstName;
	private String lastName;
	private String phone;


}
