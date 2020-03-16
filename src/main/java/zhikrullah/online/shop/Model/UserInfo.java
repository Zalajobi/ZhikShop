package zhikrullah.online.shop.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserInfo {
    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @NotEmpty(message = "Email can't be Empty")
    private String email;
    private String firstName;
    private String lastName;
    private String otherName;
    @NotEmpty(message = "Username can't be Empty")
    @Column(unique = true, nullable = false, updatable = false)
    private String userName;
    private String dateOfBirth;
    @OneToOne
    private Customer customer;
    private String phoneNumber;
    private String password;
    private String gender;
    private String country;
    private String region;
    private String passwordConfirm;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")
    })
    private List<UserRole> userRole;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateofBirth() {
        return dateOfBirth;
    }

    public void setDateofBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
}