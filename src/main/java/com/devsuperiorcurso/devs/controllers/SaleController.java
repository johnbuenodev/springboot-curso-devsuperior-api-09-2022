package com.devsuperiorcurso.devs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperiorcurso.devs.entities.Sale;
import com.devsuperiorcurso.devs.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	//Retorna lista todos
	@GetMapping
	public List<Sale> getAllSalesList() {
		return saleService.findSaleList();
	}
	
	

}
