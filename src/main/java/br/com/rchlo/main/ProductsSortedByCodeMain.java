package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsSortedByCode;

import java.util.List;

public class ProductsSortedByCodeMain {

    public static void main(String[] args) {
        ProductsSortedByCode list = new ProductsSortedByCode(ProductRepository.all());
        List<Product> sortedList = list.getSortedList();

        sortedList.forEach(product -> {
            System.out.println(product);
        });
    }
}
