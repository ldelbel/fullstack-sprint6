package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsByColor {
    public List<Product> filter(Color color, List<Product> list) {
        validate(color, list);

        List<Product> filteredList = new ArrayList<>();

        list.forEach(product -> {
            if (color.equals(product.getColor())) {
                filteredList.add(product);
            }
        });

        return filteredList;
    }

    private void validate(Color color, List<Product> list) {
        if(color == null) { throw new IllegalArgumentException("Color must be defined."); }
        if(list == null) { throw new IllegalArgumentException("List must be defined."); }
    }
}
