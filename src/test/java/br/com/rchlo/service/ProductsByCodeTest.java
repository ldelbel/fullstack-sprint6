package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.service.Nursery.ProductMother;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductsByCodeTest {

    private ProductsByCode productsByCode;
    private static Product jacket;
    private static Product tshirt;

    @BeforeAll
    static void build() {
        jacket = ProductMother.aJacket();
        tshirt = ProductMother.aTShirt();
    }

    @BeforeEach
    void setUp() {
        productsByCode = new ProductsByCode();
    }

    @Test
    void shouldReturnOnlyTheCorrectCode() {
        List<Product> products = List.of(tshirt, jacket);

        List<Product> filteredProducts = productsByCode.filter(14124998L, products);

        assertEquals(1, filteredProducts.size());

        Product product = filteredProducts.get(0);
        assertEquals(14124998L, product.getCode());
        assertEquals("Camiseta Infantil Manga Curta Super Mario", product.getName());
    }

    @Test
    void shouldReturnAnEmptyListIfTheCodeIsNotFound() {
        List<Product> products = List.of(tshirt, jacket);

        List<Product> filteredProducts = productsByCode.filter(-999L, products);

        assertEquals(0, filteredProducts.size());
    }

    @Test
    void shouldAcceptAnEmptyList() {
        List<Product> emptyProducts = List.of();

        List<Product> filteredProducts = productsByCode.filter(1L, emptyProducts);

        assertEquals(0, filteredProducts.size());
    }

    @Test
    void shouldNotAcceptANullCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            List<Product> emptyProducts = List.of();
            productsByCode.filter(null, emptyProducts);
        });
    }

    @Test
    void shouldNotAcceptANullList() {
        assertThrows(IllegalArgumentException.class, () -> productsByCode.filter(1L, null));
    }

}