package com.devsuperiorcurso.devs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperiorcurso.devs.entities.Sale;
import com.devsuperiorcurso.devs.service.SaleService;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	//Retorna lista todos
	
	@GetMapping
	public Page<Sale> getAllSalesPage(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable) {
		return saleService.findSalePage(minDate, maxDate, pageable);
	} 
	
	
	@GetMapping(path = "/all")
	public List<Sale> getAllSalesList() {
		return saleService.findSaleList();
	} 
	
	

}
