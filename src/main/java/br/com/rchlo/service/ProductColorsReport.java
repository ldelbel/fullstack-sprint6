package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ProductColorsReport {

    private static Map<Color, Integer> colorReport = new HashMap<>();

    public static void report(List<Product> list) {

        for (Color value : Color.values()) {
            colorReport.put(value, 0);
        }

        for (Product product : list) {
            if(product.getColor() != null) {
                colorReport.put(product.getColor(), colorReport.get(product.getColor()) + 1);
            }
        }

        colorReport.forEach((color, numberOfProducts) -> System.out.println("Cor: " + color + " ---> Número de produtos: " + numberOfProducts));
    }

}
