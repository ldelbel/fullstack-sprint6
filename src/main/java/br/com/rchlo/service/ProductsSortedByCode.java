package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsSortedByCode {

    private List<Product> sortedList;

    public ProductsSortedByCode(List<Product> all) {
        if (all == null || all.size() == 0) { throw new IllegalArgumentException("List argument is required."); }
        this.sortedList = new ArrayList<>(all);
    }

    public List<Product> getSortedList() {
        Collections.sort(sortedList);
        return sortedList;
    }

}
