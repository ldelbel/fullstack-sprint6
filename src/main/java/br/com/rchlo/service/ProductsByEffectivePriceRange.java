package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsByEffectivePriceRange {

    public List<Product> filter(BigDecimal minimumPrice, BigDecimal maximumPrice, List<Product> products) {
        validate(minimumPrice,maximumPrice, products);

        List<Product> filteredProductList = new ArrayList<>();

        for (Product product : products) {
            BigDecimal price = product.getEffectivePrice();
            if (price.compareTo(minimumPrice) >= 0 && price.compareTo(maximumPrice) <= 0) {
                filteredProductList.add(product);
            }
        }

        return filteredProductList;
    }

    private void validate(BigDecimal minimumPrice, BigDecimal maximumPrice, List<Product> products) {
        if (minimumPrice == null) throw new IllegalArgumentException("minimum price should not be null");
        if (maximumPrice == null) throw new IllegalArgumentException("maximum price should not be null");
        if (products == null) throw new IllegalArgumentException("product list should not be null");
    }

}
