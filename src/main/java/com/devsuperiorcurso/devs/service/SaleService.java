package com.devsuperiorcurso.devs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
