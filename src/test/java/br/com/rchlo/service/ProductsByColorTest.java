package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.Nursery.ProductMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProductsByColorTest {

    private ProductsByColor productsByColor;
    private static Product jacket;
    private static Product tshirt;

    @BeforeAll
    static void build() {
        jacket = ProductMother.aJacket();
        tshirt = ProductMother.aTShirt();
    }

    @BeforeEach
    void setUp() { productsByColor = new ProductsByColor(); }

    @Test
    public void shouldReturnFilteredListWithSeveralTShirtsCorrectly() {
        List<Product> allProducts = List.of(tshirt, tshirt, jacket, jacket);
        List<Product> filteredProducts = productsByColor.filter(Color.WHITE, allProducts);
        Assertions.assertEquals(List.of(jacket, jacket), filteredProducts);
    }

    @Test
    public void emptyListShouldReturnAnotherEmptyList() {
        List<Product> allProducts = List.of();
        List<Product> filteredProducts = productsByColor.filter(Color.WHITE, allProducts);
        Assertions.assertEquals(0, filteredProducts.size());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfColorIsNull() {
        List<Product> allProducts = List.of(tshirt, tshirt, jacket, jacket);
        Assertions.assertThrows(IllegalArgumentException.class, () -> productsByColor.filter(null, allProducts));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfListIsNull() {
        List<Product> allProducts = List.of(tshirt, tshirt, jacket, jacket);
        Assertions.assertThrows(IllegalArgumentException.class, () -> productsByColor.filter(Color.WHITE, null));
    }
}



