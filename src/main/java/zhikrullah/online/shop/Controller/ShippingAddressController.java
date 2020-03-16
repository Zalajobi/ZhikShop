package zhikrullah.online.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zhikrullah.online.shop.Model.ShippingAddress;
import zhikrullah.online.shop.Service.ShippingAddressService;

import javax.validation.Valid;

@Controller
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @RequestMapping(value = "/shippingaddress", method = RequestMethod.GET)
    public String userAddress(Model model)
    {
        model.addAttribute("shippingAddress", new ShippingAddress());
        return "shippingaddress";
    }

    @RequestMapping(value = "/shippingaddress", method = RequestMethod.POST)
    public String userAddress(@Valid ShippingAddress shippingAddress, Errors errors)
    {
        if (errors.hasErrors()) {
            return "shippingaddress";
        } else {
            shippingAddressService.createAddress(shippingAddress);
            return "index";
        }
    }
}