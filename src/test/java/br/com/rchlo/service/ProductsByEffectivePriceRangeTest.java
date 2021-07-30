package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import br.com.rchlo.service.Nursery.ProductMother;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductsByEffectivePriceRangeTest {

    private ProductsByEffectivePriceRange productsByEffectivePriceRange;
    private static Product discountedTShirt;
    private static Product expensiveJacket;
    private static Product cheapTankTop;

    @BeforeEach
    void build() {
        discountedTShirt = ProductMother.aDiscountedTShirt();
        expensiveJacket = ProductMother.anExpensiveJacket();
        cheapTankTop = ProductMother.aCheapTankTop();
    }

    @BeforeEach
    void setUp() {
        productsByEffectivePriceRange = new ProductsByEffectivePriceRange();
    }

    @Test
    void shouldReturnOnlyProductsInTheRange() {
        List<Product> products = List.of(discountedTShirt, expensiveJacket, cheapTankTop);
        BigDecimal minimumPrice = new BigDecimal("30.0");
        BigDecimal maximumPrice = new BigDecimal("40.0");

        List<Product> filteredProducts = productsByEffectivePriceRange.filter(minimumPrice, maximumPrice, products);
        System.out.println(filteredProducts);

        assertEquals(1, filteredProducts.size());

        Product product = filteredProducts.get(0);
        assertEquals(14124998L, product.getCode());
        assertEquals("Camiseta Infantil Manga Curta Super Mario", product.getName());
    }

    @Test
    void shouldWorkWithAnExactPrice() {
        List<Product> products = List.of(cheapTankTop);
        BigDecimal minimumPrice = new BigDecimal("29.90");
        BigDecimal maximumPrice = new BigDecimal("29.90");

        List<Product> filteredProducts = productsByEffectivePriceRange.filter(minimumPrice, maximumPrice, products);

        assertEquals(1, filteredProducts.size());

        Product product = filteredProducts.get(0);
        assertEquals(14040174L, product.getCode());
        assertEquals("Regata Infantil Mario Bros", product.getName());
    }

    @Test
    void shouldWorkWithAnDiscounts() {
        List<Product> products = List.of(discountedTShirt);
        BigDecimal minimumPrice = new BigDecimal("34.90");
        BigDecimal maximumPrice = new BigDecimal("34.90");

        List<Product> filteredProducts = productsByEffectivePriceRange.filter(minimumPrice, maximumPrice, products);

        assertEquals(1, filteredProducts.size());

        Product product = filteredProducts.get(0);
        assertEquals(14124998L, product.getCode());
        assertEquals("Camiseta Infantil Manga Curta Super Mario", product.getName());
    }

}