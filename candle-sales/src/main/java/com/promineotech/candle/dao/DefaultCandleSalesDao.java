package com.promineotech.candle.dao;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;



@Service
@Component   //



public class DefaultCandleSalesDao implements CandleSalesDao {
	
	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	  
	  @Override
	  public List<Option> fetchOptions(CandleType candle_type, SizeType size, ScentName scent) {
	   
	    //  @formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM options "
	        + "WHERE candle_type = :candle AND size_type = :size AND scent_name = :scent";
	    // @formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("candle", candle_type.toString());
	    params.put("size", size);
	    params.put("scent", scent);
	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {

	      @Override
	      public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
	        
//	      @formatter:off
	        return Option.builder()
	            .optionPK(rs.getLong("option_pk"))
	            .price(new BigDecimal(rs.getString("price")))
	            .build();
	      }});
	  }


}
