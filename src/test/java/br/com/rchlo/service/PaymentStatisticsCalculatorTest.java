package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import br.com.rchlo.service.Nursery.PaymentsMother;
import br.com.rchlo.service.Nursery.StatusMapMother;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Map;

class PaymentStatisticsCalculatorTest {

    private PaymentStatistics paymentStatistics;

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(paymentRepository.all()).thenReturn(PaymentsMother.all());
        Mockito.when(paymentRepository.getMaxValueFromConfirmedPayments()).thenReturn(new BigDecimal("200.00"));
        Mockito.when(paymentRepository.getPaymentsByStatus()).thenReturn(StatusMapMother.create());
        PaymentStatisticsCalculator paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
        paymentStatistics = paymentStatisticsCalculator.calculate();
    }

    @AfterEach
    void tearDown() {
        PaymentsMother.reset();
    }

    @Test
    void shouldCalculateMaximumAmountOfConfirmedPayment() {
        BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics.getMaximumAmountOfConfirmedPayment();
        Assertions.assertThat(maximumAmountOfConfirmedPayment).isEqualTo(new BigDecimal("200.00"));
    }

    @Test
    void deveConsiderarQuantidadeDePagamentoPorStatus() {
        Map<PaymentStatus, Long> quantityOfPaymentsByStatus = paymentStatistics.getQuantityOfPaymentsByStatus();
        Assertions.assertThat(quantityOfPaymentsByStatus)
                .containsEntry(PaymentStatus.CREATED, 2L)
                .containsEntry(PaymentStatus.CONFIRMED, 1L)
                .containsEntry(PaymentStatus.CANCELED, 1L);
    }

}