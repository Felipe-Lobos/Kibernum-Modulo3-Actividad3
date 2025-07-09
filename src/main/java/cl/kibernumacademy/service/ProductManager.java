package cl.kibernumacademy.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cl.kibernumacademy.model.Product;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();
    private int nextId = 1;

    public List<Product> getProducts() {
        return List.copyOf(productList);
    }

    private Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public Product addProduct(String name, String description, int price) {
        if ((price < 0) || (name.isEmpty()) || description.isEmpty() || name == null || description == null) {
            return null;
        }
        Product product = new Product(nextId++, name, description, price);
        productList.add(product);
        return product;
    }

    public Product updateProduct(int productId, String name, String description, int price) {
        if (price < 0 || name == null || description == null || name.isEmpty() || description.isEmpty()) {
            return null;
        }
        Product product = findProductById(productId);
        if (product == null) {
            return null;
        }
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return product;
    }

    public boolean deleteProduct(int productId) {
        Iterator<Product> iterador = productList.iterator();
        while (iterador.hasNext()) {
            Product product = iterador.next();
            if (product.getId() == productId) {
                iterador.remove();
                return true;
            }
        }
        return false;

    }
}
