package zhikrullah.online.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutUsController
{
    @RequestMapping(value = "aboutus", method = RequestMethod.GET)
    public String aboutUs()
    {
        return "aboutus";
    }
}