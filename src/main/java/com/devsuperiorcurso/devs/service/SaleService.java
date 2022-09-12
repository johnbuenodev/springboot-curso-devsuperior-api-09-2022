package com.devsuperiorcurso.devs.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperiorcurso.devs.entities.Sale;
import com.devsuperiorcurso.devs.repositories.SaleRepository;

@Service
public class SaleService {
  
	@Autowired
	private SaleRepository saleRepository;
	
	//retornando lista simples todos registros
	public List<Sale> findSaleList() {
		return saleRepository.findAll();
	}
	
	//retorna dados paginados 20 per page
	
	public Page<Sale> findSalePage(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate nowValue = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? nowValue.minusYears(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? nowValue : LocalDate.parse(maxDate);
		
		return saleRepository.findSalesPerPage(min, max, pageable);
	} 
}
