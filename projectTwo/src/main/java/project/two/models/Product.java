package project.two.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "product_id_seq", allocationSize = 1)
    @Column
    private int productid;

    @Column
    private String title;

    @Column
    private String category;

    @Column
    private String manufacturer;

    @Column(name="minimumlimit")
    private int minLimit;

    @OneToMany(mappedBy="product", cascade=CascadeType.ALL)
    private List<ProductStock> stock;

    public int getProductId() {
        return productid;
    }
    public void setProductId(int productId) {
        this.productid = productId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public int getMinLimit() {
        return minLimit;
    }
    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }
    public List<ProductStock> getStock() {
    	return stock;
    }
    public void setStock(List<ProductStock> stock) {
        this.stock = stock;
    }
}
