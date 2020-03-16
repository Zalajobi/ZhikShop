package zhikrullah.online.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zhikrullah.online.shop.Model.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
