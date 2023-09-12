package at.htl.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDERDETAILS", schema = "APP", catalog = "")
public class Orderdetail implements Serializable {
    @Basic
    @Column(name = "UNITPRICE", nullable = false)
    private Double unitprice;
    @Basic
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
    @Basic
    @Column(name = "DISCOUNT", nullable = false)
    private Double discount;

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", nullable = false)
    private Order ordersByOrderid;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID", nullable = false)
    private Product productsByProductid;

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderdetail that = (Orderdetail) o;

        if (unitprice != null ? !unitprice.equals(that.unitprice) : that.unitprice != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitprice != null ? unitprice.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    public Order getOrdersByOrderid() {
        return ordersByOrderid;
    }

    public void setOrdersByOrderid(Order ordersByOrderid) {
        this.ordersByOrderid = ordersByOrderid;
    }

    public Product getProductsByProductid() {
        return productsByProductid;
    }

    public void setProductsByProductid(Product productsByProductid) {
        this.productsByProductid = productsByProductid;
    }
}
