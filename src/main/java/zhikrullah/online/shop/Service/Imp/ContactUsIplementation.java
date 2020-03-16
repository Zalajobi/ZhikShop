package zhikrullah.online.shop.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhikrullah.online.shop.Model.ContactUs;
import zhikrullah.online.shop.Repository.ContactUsRepository;
import zhikrullah.online.shop.Service.ContactUsService;

@Service
public class ContactUsIplementation implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public void registerMessage(ContactUs contactUs) {
        contactUsRepository.save(contactUs);
    }
}
