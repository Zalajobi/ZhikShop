package zhikrullah.online.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zhikrullah.online.shop.Model.ContactUs;
import zhikrullah.online.shop.Service.ContactUsService;

import javax.validation.Valid;

@Controller
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @RequestMapping(method = RequestMethod.GET, value = "/contactus")
    public String contactUs(Model model)
    {
        model.addAttribute("contact", new ContactUs());
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contactus")
    public String contactUs(@Valid ContactUs contactUs, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "contact";
        } else {
            contactUsService.registerMessage(contactUs);
            return "index";
        }
    }
}