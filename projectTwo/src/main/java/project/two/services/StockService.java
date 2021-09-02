package project.two.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import project.two.dao.ProductDAO;
import project.two.dao.StockDetailsDAO;
import project.two.models.ProductStock;



@Service
public class StockService {
	
	@Autowired 
	private StockDetailsDAO repo;
	
	@Autowired
	private ProductDAO dao;

	public List<ProductStock>getStock() {
		return repo.findAll();
	}

	
}



