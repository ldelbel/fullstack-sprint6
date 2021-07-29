package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.service.ProductColorsReport;
import br.com.rchlo.service.ProductSizeReport;

public class ProductsSizeReportMain {

    public static void main(String[] args) {
        ProductSizeReport.report(ProductRepository.all());
    }
}
