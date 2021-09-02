package project.two.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.two.dao.ProductDAO;
import project.two.dao.StockDetailsDAO;
import project.two.models.Product;
import project.two.models.ProductStock;
import project.two.services.StockService;


@RestController
@RequestMapping("/stock")
@CrossOrigin

public class ProductStockController {

	@Autowired
	private StockService stockService;
	
	@Autowired 
	private StockDetailsDAO repo;
	

	@Autowired
	private ProductDAO dao;
	
	@GetMapping
	public List<ProductStock> getStock(){
		return stockService.getStock();
	}
	
	@PostMapping(value="/add",consumes="application/json")
	public ResponseEntity<ProductStock> createStock(@RequestBody ProductStock stock) {
		try {
			Product proj = dao.findById(new Integer(1)).get();
			stock.setProduct(proj);
			Date time = new Date();
			stock.setDateOfTrans(time);
			ProductStock add = repo
					.save(stock);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/add2",consumes="application/json")
	public ResponseEntity<ProductStock> createStock2(@RequestBody ProductStock stock) {
		try {
			Product proj = dao.findById(new Integer(2)).get();
			stock.setProduct(proj);
			Date time = new Date();
			stock.setDateOfTrans(time);
			ProductStock add = repo
					.save(stock);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/add3",consumes="application/json")
	public ResponseEntity<ProductStock> createStock3(@RequestBody ProductStock stock) {
		try {
			Product proj = dao.findById(new Integer(3)).get();

			stock.setProduct(proj);
			Date time = new Date();
			stock.setDateOfTrans(time);
			ProductStock add = repo		
					.save(stock);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/add3",consumes="application/json")
	public ResponseEntity<ProductStock> createStock4(@RequestBody ProductStock stock) {
		try {
			Product proj = dao.findById(new Integer(4)).get();

			stock.setProduct(proj);
			Date time = new Date();
			stock.setDateOfTrans(time);
			ProductStock add = repo		
					.save(stock);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/add3",consumes="application/json")
	public ResponseEntity<ProductStock> createStock5(@RequestBody ProductStock stock) {
		try {
			Product proj = dao.findById(new Integer(5)).get();

			stock.setProduct(proj);
			Date time = new Date();
			stock.setDateOfTrans(time);
			ProductStock add = repo		
					.save(stock);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
