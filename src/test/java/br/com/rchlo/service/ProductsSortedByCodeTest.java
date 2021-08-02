package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.service.Nursery.ProductMother;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsSortedByCodeTest {

    private ProductsSortedByCode productsSortedByCode;
    private static Product jacket;
    private static Product tshirt;
    private static Product discountedTShirt;
    private static Product expensiveJacket;
    private static Product cheapTankTop;

    @BeforeAll
    static void build() {
        jacket = ProductMother.aJacket();
        tshirt = ProductMother.aTShirt();
        discountedTShirt = ProductMother.aDiscountedTShirt();
        expensiveJacket = ProductMother.anExpensiveJacket();
        cheapTankTop = ProductMother.aCheapTankTop();
    }

    @Test
    public void shouldReturnSortedListWhenListIsGiven() {
        List<Product> notSorted = List.of(jacket, tshirt, discountedTShirt, expensiveJacket, cheapTankTop);

        assertFalse(isSorted(notSorted));

        productsSortedByCode = new ProductsSortedByCode(notSorted);
        List<Product> sorted = productsSortedByCode.getSortedList();

        assertTrue(isSorted(sorted));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> productsSortedByCode = new ProductsSortedByCode(null));
    }


    @Test // arguable
    public void shouldThrowIllegalArgumentExceptionIfListIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> productsSortedByCode = new ProductsSortedByCode(List.of()));
    }


    public boolean isSorted(List<Product> products) {
        Iterator<Product> iter = products.iterator();
        Product current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}