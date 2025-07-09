```java
package cl.kibernumacademy.service;

import java.util.ArrayList;
import java.util.List;

import cl.kibernumacademy.model.Product;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();
    private int nextId = 1;

    public List<Product> getProducts() {
        return productList;
    }

    public Product addProduct(String name, String description, int price) {
        Product product = new Product(nextId++, name, description, price);
        productList.add(product);
        return product;
    }

    public Product updateProduct(int productId, String name, String description, int price) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }
}
```