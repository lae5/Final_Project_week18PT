package com.promineotech.candle.entity;

import java.util.List;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;





@Data
public class OrderRequest {
	
	

	
	
	  @Null
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String customer;
	  
	  @NotNull
	  private CandleType candle;
	  
	  @NotNull
	  private ScentName scent;
	  
	  @NotNull
	  private SizeType size;
	  
	  @Positive
	  @Min(2)
	  @Max(4)
	  private int price;
	  
	  private List<@NotNull @Length(max = 30) @Pattern(regexp = "[\\w\\s]*") 
	  String> options;
	


}
