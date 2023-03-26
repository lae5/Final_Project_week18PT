package com.promineotech.candle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.candle.entity.Order;
import com.promineotech.candle.entity.OrderRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.Valid;
//List of functions in orders interface: create, update and delete
//communicates with DefaultCandleOrderClass
@RequestMapping("/orders") 
@OpenAPIDefinition(info= @Info(title= "Candle Order Service"), servers = {
	    @Server(url= "http://localhost:8080", description = "Local server.")})
public interface CandleOrderController {
	@Operation( //told API about the parameters
			summary = "Create an order for a candle",
			description = "Return create a candle",
			responses = {
			@ApiResponse(responseCode = "201",
			description = "The created Candle is returned", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = OrderRequest.class) )),
			@ApiResponse(responseCode = "400", 
			description = "The request parameters are invalid", 
			content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404",
			description = "A candle was not found with the input criteria",
			content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", 
			description = "An unplanned error occured", 
			content = @Content(mediaType = "application/json"))
			},
			parameters = {
			@Parameter(name = "orderRequest", 
			required = true, 
			description = "The order as JSON"),
			}
			)
	
	//creates order
			@PostMapping
			@ResponseStatus(code = HttpStatus.CREATED)
	
	        Order createOrder(@RequestBody OrderRequest orderRequest);
	//updates order
	@Operation(
			summary = "updates a Order",
			responses = {
			@ApiResponse(
			responseCode ="200", 
			description = "Returns updated Order",
			content = @Content (
			mediaType ="application/json",
			schema = @Schema(implementation = Order.class))), 
			@ApiResponse( 
			responseCode = "404", 
			description = "No Order was found",
			content = @Content(mediaType = "application/json")),
			@ApiResponse(
			responseCode = "500", 
			description = "An unplanned error occurred.", 
			content = @Content(mediaType = "application/json")),
			}, 
			parameters = {
			@Parameter(name = "orderPK", 
			allowEmptyValue = false, 
			required = false, 
			description = "The Order's Id within our database")
			}
			)
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	Order updateOrder( 
	int customerPK, 
	@Valid @RequestBody Order updatedOrder);

	//deletes order
	
	@Operation(
		    summary = "Deletes an Order",
		    description = "Deletes an Order",
		    responses = {
		        @ApiResponse(
		            responseCode = "200",
		            description = "Order was deleted",
		            content = @Content(
		                mediaType = "application/json", 
		                schema = @Schema(implementation = Order.class))),
		        @ApiResponse(
		            responseCode = "400", 
		            description = "The request parameters are invalid",  
		            content = @Content(mediaType = "application/json")),
		        @ApiResponse(
		            responseCode = "404", 
		            description = "No Orders were found with the input criteria",  
		            content = @Content(mediaType = "application/json")),
		        @ApiResponse(
		            responseCode = "500", 
		            description = "An unplanned error occurred.",  
		            content = @Content(mediaType = "application/json"))
		    },
		    parameters = {
		        @Parameter(name = "OrderPK", 
		            allowEmptyValue = false, 
		            required = false, 
		            description = "orderPK (i.e., 3)"),	
		    
		    }
		    )
	  @DeleteMapping("/OrderPK")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteOrder(int deleteId); 
}
