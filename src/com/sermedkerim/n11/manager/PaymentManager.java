package com.sermedkerim.n11.manager;

import com.sermedkerim.n11.interfaces.IPayment;

public class PaymentManager {

    private final IPayment paymentType;

    public PaymentManager(IPayment paymentType) {
        this.paymentType = paymentType;
    }

    public void pay(double cost) {
        paymentType.pay(cost);
    }
}
