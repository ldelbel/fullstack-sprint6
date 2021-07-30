package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.service.Nursery.ProductMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProductSizeReportTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static Product jacket;
    private static Product tshirt;

    @BeforeAll
    static void build() {
        jacket = ProductMother.aJacket();
        tshirt = ProductMother.aTShirt();
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfListIsNull() {
        assertThrows(IllegalArgumentException.class, () -> ProductSizeReport.report(null));
    }

    @Test
    void shouldIncludeCorrectOcurrencesOnDisplay() {
        ProductSizeReport.report(List.of(jacket, tshirt));

        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Tamanho: LARGE\n ---> Produtos: \nCódigo: 13834193 -- Nome: Jaqueta Puffer Juvenil Com Capuz Super Mario"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Tamanho: SMALL\n ---> Produtos: \nCódigo: 14124998 -- Nome: Camiseta Infantil Manga Curta Super Mario"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Tamanho: EXTRA_LARGE\n ---> Produtos: \nCódigo: 13834193 -- Nome: Jaqueta Puffer Juvenil Com Capuz Super Mario"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Tamanho: MEDIUM\n ---> Produtos: \nCódigo: 14124998 -- Nome: Camiseta Infantil Manga Curta Super Mario"));
    }
}
