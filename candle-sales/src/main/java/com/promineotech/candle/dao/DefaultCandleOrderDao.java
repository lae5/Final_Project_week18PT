package com.promineotech.candle.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Customer;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.Order;
import com.promineotech.candle.entity.OrderRequest;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;


@Component


public class DefaultCandleOrderDao implements CandleOrderDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public Order saveOrder(Customer customer, CandleType candle, SizeType size, ScentName scent, BigDecimal price, List<Option> options) {
	SqlParams params = generateInsertSql(customer, candle, size, scent, price);
	KeyHolder keyholder = new GeneratedKeyHolder();
	jdbcTemplate.update(params.sql, params.source, keyholder);
	Long orderPk = keyholder.getKey().longValue();
	saveOptions(options, orderPk);
	//@formatter:off
	return Order.builder()
           .orderPK(orderPk)  
           .options(options)
           .quantity(0)
           .build();
	//@formatter:on
	}
	private SqlParams generateInsertSql(Customer customer, CandleType candle, SizeType size, ScentName scent,
			BigDecimal price) {
		
		return null;
	}
	private void saveOptions(List<Option> options, Long orderPk) {
	for(Option option : options) {
	SqlParams params = generateInsertSql(option, orderPk);
	jdbcTemplate.update(params.sql, params.source);
	}
	} /**
	* 
	* @paramoption
	* @paramorderPK
	* @return
	*/
	private SqlParams generateInsertSql(Option option, Long orderPK) {
	SqlParams params = new SqlParams();
	// @formatter:off
	params.sql = ""
	+ "INSERT INTO order_options ("
	+ "option_fk, order_fk"
	+ ") VALUES ("
	+ ":option_fk, :order_fk"
	+ ")";
	// @formatter:on
	params.source.addValue("option_fk", option.getOptionPk());
	params.source.addValue("order_fk", orderPK);
	return params;
	}
	public List<Option> fetchOptions(List<String> optionIds) {
	if (optionIds.isEmpty()) {
	return new LinkedList<>();
	}
	Map<String, Object> params = new HashMap<>();
	// @formatter:off
	String sql = ""
	+ "SELECT * "
	+ "FROM options "
	+ "WHERE option_id IN(";
	// @formatter:on
	for (int index = 0; index < optionIds.size(); index++) {
	String key = "option_" + index;
	sql += ":" + key + ", ";
	params.put(key, optionIds.get(index));
	}
	sql = sql.substring(0, sql.length() - 2);
	sql += ")";
	return jdbcTemplate.query(sql, params, new RowMapper<Option>() {
	public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
	// @formatter:off
	return 	Option.builder()
            .optionPK(rs.getLong("option_pk"))
            .price(new BigDecimal(rs.getString("price")))
            .build();
		// @formatter:on
	}
	});
	}
	public Optional<Customer> fetchCustomer(String customerId) {
	// @formatter:off
	String sql = "" 
	+ "SELECT * " 
	+ "FROM customers "
	+ "WHERE customer_id = :customer_id";
	// @formatter:on
	Map<String, Object> params = new HashMap<>();
	params.put("customer_id", customerId);
	return Optional.ofNullable(
	jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
	}
	@Override
	public Optional<SizeType> fetchSizeType(SizeType size_type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Order createOrder(OrderRequest orderRequest) {
		
		return null;
	}
	public Optional<CandleType> fetchCandleType(CandleType candleId) {
		
		return Optional.empty();
	}
	public Optional<ScentName> fetchScentName(ScentName scentId) {
	
		return Optional.empty();
	}
	public Order saveOrder(Customer customer, CandleType candle, ScentName scent, SizeType size, BigDecimal price,
			List<Option> options) {
		
		return null;
	} 
	
		}
	class CustomerResultSetExtractor implements ResultSetExtractor<Customer> {
	@Override
	public Customer extractData(ResultSet rs) 
	throws SQLException, DataAccessException {
	rs.next();
	//@formatter:off
	return Customer.builder()
	.customerPK(rs.getLong("customer_pk"))
	.firstName(rs.getString("first_name"))
	.lastName(rs.getString("last_name"))
	.phone(rs.getString("phone"))
	.build();
	//@formatter:on
	}
	}
	class SqlParams {
	String sql;
	MapSqlParameterSource source = new MapSqlParameterSource();
	
	
	public Order createOrder(OrderRequest orderRequest) {
	// TODO Auto-generated method stub
	return null;
	}
	
	public Object fetchSizeType(SizeType size_type) {
		// TODO Auto-generated method stub
		return null;
	}
	





	

}
