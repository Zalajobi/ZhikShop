package zhikrullah.online.shop.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zhikrullah.online.shop.Model.UserInfo;
import zhikrullah.online.shop.Model.UserRole;
import zhikrullah.online.shop.Repository.UserRepository;
import zhikrullah.online.shop.Service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean hasUserWithEmail(String email) {
//        UserDetails userDetails = userRepository.findByEmail(email);
        if (userRepository.findByEmail(email) == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean hasUserWithUserName(String userName) {
        if (userRepository.findByUserName(userName) == null)
            return false;
        else
            return true;
    }

    @Override
    public void createUser(UserInfo userInfo) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        UserRole userRole = new UserRole("USER");
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(userRole);
        userInfo.setUserRole(userRoleList);
        userRepository.save(userInfo);
    }
}