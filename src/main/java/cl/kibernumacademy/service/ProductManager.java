package cl.kibernumacademy.service;

import java.util.ArrayList;
import java.util.List;

import cl.kibernumacademy.model.Product;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();
    private int nextId = 1;

    public Product addProduct(String name, String description, int price){
        Product product = new Product(nextId++, name,description,price);
        productList.add(product);
        return product;
    }
}
