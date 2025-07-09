```java
package cl.kibernumacademy;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import cl.kibernumacademy.model.Product;
import cl.kibernumacademy.service.ProductManager;

public class ProductManagerTest {
    ProductManager productManager;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager();
    }

    // Pruebas parametrizadas
    @DisplayName("Prueba agregar productos a la lista")
    @ParameterizedTest
    @CsvSource({
        "Laptop, Asus x123, 900000",
        "Macbook, Bonita roja, 2500000",
        ",Descripcion de prueba, 10000",
        "Nombre producto,, 20000",
    })
    void shouldAddProductWhenDataIsValid(String name, String description, int price){

        // Se valida que name y description no sean null, y price sea un valor mayor a 0
        assumeTrue(name != null && description != null && price > 0); 

        // Se agrega el producto valido
        Product product = productManager.addProduct(name,description,price); 

        // Aserciones tradicionales JUnit5

        // Comprobar que el nuevo producto no sea null
        assertNotNull(product, "Producto no deberia ser nulo"); 
        // Comprobar que el nombre del nuevo producto sea el mismo que venia en los parametros
        assertEquals(name, product.getName()); 

        // Hamcrest

        // Comprobar que el listado de productos tenga un tamaño de 1
        assertThat(productManager.getProducts(),hasSize(1));
    }

    @AfterEach
    void tearDown() {

    }

    // Pruebas parametrizadas
    @ParameterizedTest
    @CsvSource({
        "Laptop, Asus x123, 900000",
        "Macbook, Bonita roja, 2500000",
        "CPUx100, Prueba sin nombre, 0",
    })
    void updateProductTest(String name, String description, int price){
        // Producto de prueba 
        Product product = productManager.addProduct("Prueba de producto","descripcion de prueba",0);

        // Se valida que los parametros name y description no sean null, y price sea un valor mayor a 0
        assumeTrue(name != null && description != null && price > 0); 

        // Se actualiza el producto con los datos validos
        Product productUpdated = productManager.updateProduct(product.getId(),name,description,price); 

        //Supocicion de Junit

        // Se comprueba que el producto actualizado no es null
        assumingThat(productUpdated != null,()-> { 
            //Aserciones Hamcrest

            // Comprobar que el name del producto actualizado sea el mismo que el del parametro
            assertThat(productUpdated.getName(), is(name)); 
        });
    }

    @Test
    void deleteProductTest(){
        Product product = productManager.addProduct("Computador","Lenovo Yoga pro x",1200000);
        boolean deleted = productManager.deleteProduct(product.getId());
        assertThat(productManager.getProducts(),hasSize(0));
        assertTrue(deleted);        
    }

    

}

```
