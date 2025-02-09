package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.service.Nursery.ProductMother;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductColorsReportTest {

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
        assertThrows(IllegalArgumentException.class, () -> ProductColorsReport.report(null));
    }

    @Test
    void shouldIncludeCorrectOcurrencesOnDisplay() {
        ProductColorsReport.report(List.of(jacket, tshirt));

        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Cor: BLUE ---> Número de produtos: 1"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Cor: GREEN ---> Número de produtos: 0"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Cor: GRAY ---> Número de produtos: 0"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Cor: PINK ---> Número de produtos: 0"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Cor: RED ---> Número de produtos: 0"));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains("Cor: WHITE ---> Número de produtos: 1"));
    }
}