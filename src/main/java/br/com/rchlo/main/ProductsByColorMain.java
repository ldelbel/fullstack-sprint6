package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;

import java.util.List;

public class ProductsByColorMain {
    public List<Product> main() {
        List<Product> list = ProductRepository.all();
        return list;
    }
}
