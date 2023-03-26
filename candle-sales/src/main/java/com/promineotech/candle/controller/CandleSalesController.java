package com.promineotech.candle.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

import com.promineotech.candle.entity.CandleType;
import com.promineotech.candle.entity.Option;
import com.promineotech.candle.entity.ScentName;
import com.promineotech.candle.entity.SizeType;

@RequestMapping("/options")//
@OpenAPIDefinition(info= @Info(title= "Candle Sales Service"), servers = {
	    @Server(url= "http://localhost:8080", description = "Local server.")})
public interface CandleSalesController {

	@Operation( //told API about the parameters
			summary = "Return a list of Options",
			description = "Return a list of candle options",
			responses = {
			@ApiResponse(responseCode = "200",
			description = "A list of candle options is returned", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = Option.class) )),
			@ApiResponse(responseCode = "400", 
			description = "The request parameters are invalid", 
			content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404",
			description = "No options were found with the input criteria",
			content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "500", 
			description = "An unplanned error occured", 
			content = @Content(mediaType = "application/json"))
			},
			parameters = {
			@Parameter(name = "candle_type", allowEmptyValue = false, 
			required = false, 
			description = "The candle type (i.e, 'JAR')"),
			@Parameter(name = "size_type", allowEmptyValue = false,
			description = "The candle size (i.e, 'SMALL')"),
			@Parameter(name = "scent", allowEmptyValue = false,
			description = "The scent (i.e, 'VANILLA')")
			}
			)
			@GetMapping
			@ResponseStatus(code = HttpStatus.OK)
			List<Option> fetchOptions(@RequestParam CandleType candle, 
			@RequestParam SizeType size, @RequestParam ScentName scent);


	

}
