package zhikrullah.online.shop.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private UserInfo userInfo;
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<ShippingAddress> shippingAddress;

    public Customer() {
    }

    public Customer(UserInfo userInfo, List<ShippingAddress> shippingAddress) {
        this.userInfo = userInfo;
        this.shippingAddress = shippingAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<ShippingAddress> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(List<ShippingAddress> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}