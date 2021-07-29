package br.com.rchlo.service;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ProductsByColorTest {

    private ProductsByColor productsByColor;

    @BeforeEach
    void setUp() { productsByColor = new ProductsByColor(); }

    @Test
    public void shouldReturnFilteredListWithSeveralTShirtsCorrectly() {
        List<Product> allProducts = List.of(aTShirt(), aTShirt(), aJacket(), aJacket());

        List<Product> filteredProducts = productsByColor.filter(Color.WHITE, allProducts);

       Assertions.assertEquals(List.of(aJacket(), aJacket()), filteredProducts);
    }

    @Test
    public void emptyListShouldReturnAnotherEmptyList() {
        List<Product> allProducts = List.of();

        List<Product> filteredProducts = productsByColor.filter(Color.WHITE, allProducts);

        Assertions.assertEquals(0, filteredProducts.size());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfColorIsNull() {
        List<Product> allProducts = List.of(aTShirt(), aTShirt(), aJacket(), aJacket());
        Assertions.assertThrows(IllegalArgumentException.class, () -> productsByColor.filter(null, allProducts));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfListIsNull() {
        List<Product> allProducts = List.of(aTShirt(), aTShirt(), aJacket(), aJacket());
        Assertions.assertThrows(IllegalArgumentException.class, () -> productsByColor.filter(Color.WHITE, null));
    }

    private Product aJacket() {
        return new Product(13834193L,
                "Jaqueta Puffer Juvenil Com Capuz Super Mario",
                "A Jaqueta Puffer Juvenil Com Capuz Super Mario é confeccionada em material sintético. Possui estrutura ampla e modelo puffer, com capuz em pelúcia e bolsos frontais. Ideal para compor looks de inverno, mas sem perder o estilo. Combine com uma camiseta, calça jeans e tênis colorido.",
                "jaqueta-puffer-juvenil-com-capuz-super-mario-13834193_sku",
                "Nintendo",
                new BigDecimal("199.90"),
                null,
                Color.WHITE,
                147,
                "https://static.riachuelo.com.br/RCHLO/13834193003/portrait/3107b7473df334c6ff206cd78d16dec86d7dfe9a.jpg",
                Set.of(Size.LARGE, Size.EXTRA_LARGE));
    }

    private Product aTShirt() {
        return new Product(14124998L,
                "Camiseta Infantil Manga Curta Super Mario",
                "A Camiseta Infantil Manga Curta Super Mario é confeccionada em malha macia e possui decote careca, mangas curtas e padronagem do Super Mario. Aposte na peça na hora de compor visuais geek divertidos.",
                "camiseta-infantil-manga-curta-super-mario-14124998_sku",
                "Nintendo",
                new BigDecimal("39.90"),
                new BigDecimal("5.0"),
                Color.BLUE,
                116,
                "https://static.riachuelo.com.br/RCHLO/14124998004/portrait/cd948d80fe8a1fdc873f8dca1f3c4c468253bf1d.jpg",
                Set.of(Size.SMALL, Size.MEDIUM));
    }




}



