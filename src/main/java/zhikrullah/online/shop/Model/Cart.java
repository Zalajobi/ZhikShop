package zhikrullah.online.shop.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Link cart and product together and create a new Table for both variable
//    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    @OneToMany
    @JoinTable(name = "cart_products", joinColumns = {
            @JoinColumn(name = "Cart_Id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "Cart_Item", referencedColumnName = "productName")})
    private List<Product> product;
    private double price;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}