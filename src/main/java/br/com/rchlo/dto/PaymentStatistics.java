package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PaymentStatistics {

    private BigDecimal maximumAmountOfConfirmedPayment;
    private Map<PaymentStatus, Long> paymentsByStatus;

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
        paymentsByStatus = new HashMap<>();
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return this.paymentsByStatus;
    }

    public void addPaymentForStatus(PaymentStatus status) {
        Long quantity = this.paymentsByStatus.get(status);
        if (quantity == null) {
            quantity = 1L;
        } else {
            quantity++;
        }
        this.paymentsByStatus.put(status, quantity);
    }
}
