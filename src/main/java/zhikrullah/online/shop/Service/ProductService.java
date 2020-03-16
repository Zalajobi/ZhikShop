package zhikrullah.online.shop.Service;

import zhikrullah.online.shop.Model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product, List<String> imageNames);

    void addProduct(Product product);
}