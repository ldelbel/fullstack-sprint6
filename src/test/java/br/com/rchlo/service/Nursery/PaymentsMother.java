package br.com.rchlo.service.Nursery;

import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class PaymentsMother {

    private static List<Payment> allPayments = new ArrayList<>();

    public static List<Payment> all() {
        Card cardOne = new Card("ANDERSON DA SILVA", "1111 2222 3333 4444", YearMonth.parse("2022-07"), "123");
        Payment paymentOne = new Payment(Long.valueOf(1), new BigDecimal("51.80"), cardOne, PaymentStatus.CREATED);

        Card cardTwo = new Card("CAROLINE SOUZA", "1234 1234 1234 1234", YearMonth.parse("2023-06"), "234");
        Payment paymentTwo = new Payment(Long.valueOf(2), new BigDecimal("3000.00"), cardOne, PaymentStatus.CREATED);

        Card cardThree = new Card("MARIA SILVA", "1111 1111 1111 1111", YearMonth.parse("2024-05"), "456");
        Payment paymentThree = new Payment(Long.valueOf(3), new BigDecimal("200.00"), cardOne, PaymentStatus.CONFIRMED);

        Card cardFour = new Card("JOÃO QUEIROZ", "2222 3333 2222 4444", YearMonth.parse("2025-04"), "567");
        Payment paymentFour = new Payment(Long.valueOf(4), new BigDecimal( "400.00"), cardOne, PaymentStatus.CANCELED);

        allPayments.add(paymentOne);
        allPayments.add(paymentTwo);
        allPayments.add(paymentThree);
        allPayments.add(paymentFour);

        return allPayments;
    }

    public static void reset() {
        allPayments = new ArrayList<>();
    }


}
