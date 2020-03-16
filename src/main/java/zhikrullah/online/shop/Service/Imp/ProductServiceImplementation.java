package zhikrullah.online.shop.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhikrullah.online.shop.Model.Product;
import zhikrullah.online.shop.Repository.ProductRepository;
import zhikrullah.online.shop.Service.ProductService;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product, List<String> imageNames) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : imageNames)
        {
            stringBuilder.append(name + "@");
        }
        product.setImage(stringBuilder.toString());
        productRepository.save(product);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
}