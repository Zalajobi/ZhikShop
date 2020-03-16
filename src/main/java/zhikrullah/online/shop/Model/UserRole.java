package zhikrullah.online.shop.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class UserRole {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    @ManyToMany(mappedBy = "userRole")
    private List<UserInfo> userInfo;

    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return name;
    }

    public void setRoleName(String roleName) {
        this.name = roleName;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }
}