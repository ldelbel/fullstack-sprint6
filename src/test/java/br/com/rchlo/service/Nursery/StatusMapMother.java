package br.com.rchlo.service.Nursery;

import br.com.rchlo.domain.PaymentStatus;
import java.util.HashMap;
import java.util.Map;

public class StatusMapMother {

    public static Map<PaymentStatus, Long> create() {

        Map<PaymentStatus, Long> quantityByStatus = new HashMap<>();

        quantityByStatus.put(PaymentStatus.CONFIRMED, 1L);
        quantityByStatus.put(PaymentStatus.CREATED, 2L);
        quantityByStatus.put(PaymentStatus.CANCELED, 1L);

        return quantityByStatus;
    }
}
