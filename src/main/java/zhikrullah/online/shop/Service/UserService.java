package zhikrullah.online.shop.Service;

import zhikrullah.online.shop.Model.UserInfo;

public interface UserService {

    boolean hasUserWithEmail(String email);

    boolean hasUserWithUserName(String userName);

    void createUser(UserInfo userInfo);
}