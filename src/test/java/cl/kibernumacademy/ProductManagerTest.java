package cl.kibernumacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProductManagerTest {
    ProductManager productManager;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager();
    }

    @test
    void addProductTest(){
        Product product = productManager.addProduct('Computador','Lenovo Yoga pro x',1200000);
        assertNotNull(product, "Producto no deberia ser nulo");
        assertEquals('Computador', product.getName());
        //probar la lista
        assertThat(productManager.getProducts(),hasSize(1));
    }

    @ParameterizedTest
    @CsvSource({"Laptop, Asus x123, 900000","Macbook, Bonita, 2500000"})
    void updateProductTest(String nombre, String descripcion, int precio){
        Product product = productManager.addProduct('Computador','Lenovo Yoga pro x',1200000);
        
        Product productUpdated = productManager.updateProduct(product.getId(),nombre,descripcion,precio);
        assertNotEquals(product, productUpdated);
        assertThat(productUpdated.getName(), is(nombre));
    }

    @Test
    void deleteProductTest(){
        Product product = productManager.addProduct('Computador','Lenovo Yoga pro x',1200000);
        boolean deleted = productManager.deleteProduct(product.getId());
        assertThat(productManager.getProducts(),hasSize(0));
        assertTrue(deleted);
        
    }

}
