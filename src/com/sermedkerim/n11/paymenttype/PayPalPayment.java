package com.sermedkerim.n11.paymenttype;

import com.sermedkerim.n11.interfaces.IPayment;

public class PayPalPayment implements IPayment {
    @Override
    public void pay(double cost) {
        System.out.println(cost + " TL PayPal ile ödendi.");
    }
}
