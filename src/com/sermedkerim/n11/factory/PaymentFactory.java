package com.sermedkerim.n11.factory;

import com.sermedkerim.n11.interfaces.IPayment;

public class PaymentFactory {
    public IPayment create(String className)
    {
        Class c;
        IPayment payment;

        try
        {
            c  = Class.forName("com.sermedkerim.n11.paymenttype."+className);
            payment = (IPayment) c.newInstance();
        } catch (ClassNotFoundException e){
            System.out.println("Ödeme Yöntemi Bulunamadı");
            payment = null;
        }
        catch (Exception e) {
            System.out.println("İşlem sırasında hata oluştu.");
            payment = null;
        }

        return payment;
    }
}
