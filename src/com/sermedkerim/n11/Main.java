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
            int index = scanner.nextInt();

            System.out.println("Ödenecek miktarı giriniz: ");
            double cost = scanner.nextDouble();

            PaymentManager paymentManager = new PaymentManager(payments.get(index));
            paymentManager.pay(cost);

            System.out.println("Tekrar denemek istiyor musunuz?(Evet/Hayır) ");
            String answer = scanner.nextLine();

            if (answer.compareTo("Evet") != 0){
                isOpen = false;
                scanner.close();
            }
        }
    }
}