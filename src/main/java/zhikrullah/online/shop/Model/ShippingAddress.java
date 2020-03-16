package zhikrullah.online.shop.Model;

import javax.persistence.*;

@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String country;
    private String state;
    private String city;
    @Column(name = "address")
    private String homeAddress;
    @Column(name = "number")
    private String shippingPhoneNumber;
    @Column(name = "alternative_Number")
    private String alternativeShippingPhoneNumber;
    private String postalCode;
    @ManyToOne
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getShippingPhoneNumber() {
        return shippingPhoneNumber;
    }

    public void setShippingPhoneNumber(String shippingPhoneNumber) {
        this.shippingPhoneNumber = shippingPhoneNumber;
    }

    public String getAlternativeShippingPhoneNumber() {
        return alternativeShippingPhoneNumber;
    }

    public void setAlternativeShippingPhoneNumber(String alternativeShippingPhoneNumber) {
        this.alternativeShippingPhoneNumber = alternativeShippingPhoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}