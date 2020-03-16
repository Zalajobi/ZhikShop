package zhikrullah.online.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zhikrullah.online.shop.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}