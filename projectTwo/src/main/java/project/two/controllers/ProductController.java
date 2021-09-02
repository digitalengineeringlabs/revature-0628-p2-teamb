package project.two.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.two.services.ProductService;

@RestController
@RequestMapping(path="/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="onDemand", produces="application/json")
	public ResponseEntity<Object> getOnDemand() {
		return new ResponseEntity<Object>(prodService.getOnDemand(), HttpStatus.OK);
	}
	
}
