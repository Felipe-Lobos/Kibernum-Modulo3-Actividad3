package cl.kibernumacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductManager productManager;

    @BeforeEach
    void setUp(){
        productManager = new ProductManager();
    }

    @test
    void addProductTest(){
        Product product = productManager.addProduct('Computador','Lenovo Yoga pro x',1200000);
        assertNotNull(product, "Producto no deberia ser nulo");
        assertEquals('Computador', product.getName());
    }

    @Test
    void updateProductTest(){
        Product product = productManager.addProduct('Computador','Lenovo Yoga pro x',1200000);
        Product productUpdated = productManager.updateProduct(product.getId(),'Laptop','Asus algo',90000);
        assertNotEquals(product, productUpdated);
    }

    @Test
    void deleteProductTest(){
        Product product = productManager.addProduct('Computador','Lenovo Yoga pro x',1200000);
        boolean deleted = productManager.deleteProduct(product.getId());
        assertThat()
        

    }

}
