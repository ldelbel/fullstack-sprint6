package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.data.PaymentRepository;
import java.math.BigDecimal;
import java.util.Map;

public class PaymentStatistics {

    private final BigDecimal maximumAmountOfConfirmedPayment;
    private Map<PaymentStatus, Long> paymentsByStatus;

    public PaymentStatistics(PaymentRepository payments) {
        this.maximumAmountOfConfirmedPayment = payments.getMaxValueFromConfirmedPayments();
        this.paymentsByStatus = payments.getPaymentsByStatus();
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return this.paymentsByStatus;
    }

}
