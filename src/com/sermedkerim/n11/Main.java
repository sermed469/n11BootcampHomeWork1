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

        Scanner scanner = new Scanner(System.in);;
        boolean isOpen = true;

        while (isOpen) {
            System.out.println("Hangi ödeme yöntemini kullanacaksınız? (Kredi Kartı için 0 Paypal için 1 giriniz) ");
            int index = 0;
            try {
                index = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Hatalı giriş yaptınız...");
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

            PaymentManager paymentManager = new PaymentManager(payments.get(index));
            paymentManager.pay(cost);

            System.out.println("Tekrar denemek istiyor musunuz?(Evet/Hayır) ");
            String answer = scanner.next();

            if (answer.compareTo("Evet") != 0){
                isOpen = false;
                scanner.close();
            }
        }
    }
}