package project.two.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.two.models.ProductStock;



@Repository
public interface StockDetailsDAO extends JpaRepository<ProductStock, Integer>{
}
