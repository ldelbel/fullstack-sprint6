package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSizeReport {

    private static final Map<Size, List<Product>> sizeReport = new HashMap<>();

    public static void report(List<Product> list) {
        if (list == null) { throw new IllegalArgumentException("List must be given and must be valid"); }

        for (Size value : Size.values()) {
            sizeReport.put(value, new ArrayList<>());
        }

        for (Product product : list) {
            for (Size size : product.getAvailableSizes()) sizeReport.put(size, addProductAndReturnNewList(size, product));
        }

        sizeReport.forEach((size, products) -> System.out.println("Tamanho: ".concat(size.toString()).concat("\n ---> Produtos: \n").concat(template(products))));
    }

    private static List<Product> addProductAndReturnNewList(Size size, Product product) {
        sizeReport.get(size).add(product);
        return sizeReport.get(size);
    }

    private static String template(List<Product> products) {
        StringBuilder lines = new StringBuilder();
        products.forEach(product ->
            { lines.append("Código: ")
                    .append(product.getCode().toString())
                    .append(" -- Nome: ")
                    .append(product.getName())
                    .append("\n");}
        );

        return String.valueOf(lines);
    }
}
