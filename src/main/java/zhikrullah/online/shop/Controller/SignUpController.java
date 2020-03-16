package zhikrullah.online.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zhikrullah.online.shop.Model.UserInfo;
import zhikrullah.online.shop.Model.UserRole;
import zhikrullah.online.shop.Service.UserService;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model)
    {
        model.addAttribute("reg", new UserInfo());
        return "signup";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@Valid UserInfo userInfo, Model model, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "signup";
        if (userService.hasUserWithEmail(userInfo.getEmail()))
        {
            model.addAttribute("emailExist", true);
            return "signup";
        }
        if (userService.hasUserWithUserName(userInfo.getUserName()))
        {
            model.addAttribute("user_NameExist", true);
            return "signup";
        }
        else {
            userService.createUser(userInfo);
            return "login";
        }
    }
}