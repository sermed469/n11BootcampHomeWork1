# n11HomeWork1

Java console application for a simple payment flow using a shared interface, a manager class, and a factory-based payment selection mechanism.

## Overview

The application:

- asks the user to enter a payment type
- creates the matching payment implementation through `PaymentFactory`
- asks for the payment amount
- processes the payment through `PaymentManager`
- repeats until the user exits

This project demonstrates basic object-oriented design with interfaces, concrete implementations, and runtime object creation.

## Architecture

- `IPayment` defines the contract for all payment types.
- `CreditCardPayment` and `PayPalPayment` implement the payment behavior.
- `PaymentFactory` creates the requested payment class dynamically.
- `PaymentManager` delegates the payment call to the selected implementation.
- `Main` handles the console interaction loop.

## Project Structure

```text
src/com/sermedkerim/n11/
├── Main.java
├── factory/
│   └── PaymentFactory.java
├── interfaces/
│   └── IPayment.java
├── manager/
│   └── PaymentManager.java
└── paymenttype/
    ├── CreditCardPayment.java
    └── PayPalPayment.java
```

## Supported Payment Types

The program expects one of these class names as input:

- `CreditCardPayment`
- `PayPalPayment`

If a different value is entered, the application prints `Ödeme Yöntemi Bulunamadı` and stops.

## How It Works

1. `Main` asks for a payment type.
2. `PaymentFactory` tries to create a class under `com.sermedkerim.n11.paymenttype`.
3. If the class is found, `PaymentManager` is created with that payment implementation.
4. The user enters the amount.
5. The selected payment type prints the payment result.
6. The user enters `Evet` to continue or any other value to exit.

## Technologies

- Java
- OOP
- Interface-based design
- Factory pattern

## Prerequisites

- JDK 8 or later

## Compile and Run

Compile:

```bash
javac -d out $(find src -name "*.java")
```

Run:

```bash
java -cp out com.sermedkerim.n11.Main
```

## Example

```text
Ödeme yöntemini giriniz(CreditCardPayment/PayPalPayment):
CreditCardPayment
Ödenecek miktarı giriniz:
250
250.0 TL Kredi Kartı ile ödendi
Tekrar denemek istiyor musunuz?(Evet/Hayır)
Hayır
```

## Notes

- Payment type input is case-sensitive because the factory loads the class by exact name.
- Amount input must be numeric. Invalid numeric input prints `Hatalı giriş yaptınız...` and ends the program.
- The loop continues only when the user enters `Evet` ignoring case.

## Author

Sermed Kerim
