package com.devsuperiorcurso.devs.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperiorcurso.devs.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT s FROM Sale s WHERE s.date BETWEEN :minDate AND :maxDate ORDER BY s.amount DESC")	
	Page<Sale> findSalesPerPage(LocalDate minDate, LocalDate maxDate, Pageable pageable);
	
}
