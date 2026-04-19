package com.sermedkerim.n11;

import com.sermedkerim.n11.factory.PaymentFactory;
import com.sermedkerim.n11.interfaces.IPayment;
import com.sermedkerim.n11.manager.PaymentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PaymentFactory paymentFactory = new PaymentFactory();
        Scanner scanner = new Scanner(System.in);;
        boolean isOpen = true;

        while (isOpen) {
            System.out.println("Ödeme yöntemini giriniz(CreditCardPayment/PayPalPayment): ");
            String paymentTypeText = scanner.next();

            IPayment paymentType = paymentFactory.create(paymentTypeText);

            PaymentManager paymentManager = null;
            if (paymentType != null) {
                paymentManager = new PaymentManager(paymentType);
            } else {
                break;
            }

            System.out.println("Ödenecek miktarı giriniz: ");
            double cost = 0;
            try {
                cost = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Hatalı giriş yaptınız...");
                break;
            }
            paymentManager.pay(cost);


            System.out.println("Tekrar denemek istiyor musunuz?(Evet/Hayır) ");
            String answer = scanner.next();

            if (answer.compareToIgnoreCase("Evet") != 0){
                isOpen = false;
                scanner.close();
            }
        }
    }
}