package zhikrullah.online.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zhikrullah.online.shop.Model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByEmail(String email);

    UserInfo findByUserName(String userName);
}