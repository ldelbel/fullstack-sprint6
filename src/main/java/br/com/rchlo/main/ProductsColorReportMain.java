package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.service.ProductColorsReport;

public class ProductsColorReportMain {

    public static void main(String[] args) {
        ProductColorsReport.report(ProductRepository.all());
    }
}
