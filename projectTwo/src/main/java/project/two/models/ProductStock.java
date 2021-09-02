package project.two.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product_stock")
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "product_stock_id_seq", allocationSize = 1)
    @Column(name="product_stock_id")
    private int warehouseStockId;


    @ManyToOne
    @JoinColumn(name="product_ref_id", nullable=false)
    private Product product;

    @Column(name="transaction_date")
    private Date dateOfTrans;

    private String vendor;

    @Column(name="batch_code")
    private String batchCode;

    @Column(name="invoice_number")
    private String invoiceNum;

    @Column
    private int quantity;

    @Column(name="transaction_type")
    private String transType;

    public int getWarehouseStockId() {
        return warehouseStockId;
    }
    public void setWarehouseStockId(int warehouseStockId) {
        this.warehouseStockId = warehouseStockId;
    }

    public Date getDateOfTrans() {
        return dateOfTrans;
    }
    public void setDateOfTrans(Date dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getBatchCode() {
        return batchCode;
    }
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }
    public String getInvoiceNum() {
        return invoiceNum;
    }
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getTransType() {
        return transType;
    }
    public void setTransType(String transType) {
        this.transType = transType;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}