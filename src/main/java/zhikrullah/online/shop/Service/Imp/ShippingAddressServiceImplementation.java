package zhikrullah.online.shop.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhikrullah.online.shop.Model.ShippingAddress;
import zhikrullah.online.shop.Repository.ShippingAddressRepository;
import zhikrullah.online.shop.Service.ShippingAddressService;

@Service
public class ShippingAddressServiceImplementation implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;


    @Override
    public void createAddress(ShippingAddress shippingAddress) {
        shippingAddressRepository.save(shippingAddress);
    }
}