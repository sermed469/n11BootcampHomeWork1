package com.sermedkerim.n11;

import com.sermedkerim.n11.interfaces.IPayment;
import com.sermedkerim.n11.manager.PaymentManager;
import com.sermedkerim.n11.paymenttype.CreditCardPayment;
import com.sermedkerim.n11.paymenttype.PayPalPayment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<IPayment> payments = new ArrayList<>();

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PayPalPayment payPalPayment = new PayPalPayment();

        payments.add(creditCardPayment);
        payments.add(payPalPayment);

        Scanner scanner = new Scanner();

        int index = 0;
        PaymentManager paymentManager = new PaymentManager(payments.get(index));

        double cost = 1000.0;
        paymentManager.pay(cost);
    }
}