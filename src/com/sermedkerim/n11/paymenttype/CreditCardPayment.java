package com.sermedkerim.n11.paymenttype;

import com.sermedkerim.n11.interfaces.IPayment;

public class CreditCardPayment implements IPayment {
    @Override
    public void pay(double cost) {
        System.out.println("Pay with Credit Card: " + cost + " TL");
    }
}
