# n11HomeWork1

Simple Java console application that demonstrates a payment flow using different payment methods through a common interface.

## Overview

The project lets the user:

- choose a payment method
- enter an amount
- process the payment through the selected implementation
- repeat the flow until the user exits

The code uses a small strategy-style design:

- `IPayment` defines the payment contract
- `CreditCardPayment` and `PayPalPayment` implement that contract
- `PaymentManager` delegates the payment call to the selected implementation
- `Main` handles user interaction from the console

## Project Structure

```text
src/com/sermedkerim/n11/
├── Main.java
├── interfaces/
│   └── IPayment.java
├── manager/
│   └── PaymentManager.java
└── paymenttype/
    ├── CreditCardPayment.java
    └── PayPalPayment.java
```

## Technologies

- Java
- Object-oriented programming
- Interface-based design

## How It Works

1. The application starts in `Main`.
2. Available payment methods are added to a list.
3. The user selects a payment type:
   - `0` for credit card
   - `1` for PayPal
4. The user enters the payment amount.
5. `PaymentManager` calls the selected payment implementation.
6. The user can continue by entering `Evet` or exit with any other answer.

The current version also includes basic validation for invalid menu input and accepts `Evet` without case sensitivity.

## Run the Project

Compile:

```bash
javac -d out $(find src -name "*.java")
```

Run:

```bash
java -cp out com.sermedkerim.n11.Main
```

## Example Output

```text
Hangi ödeme yöntemini kullanacaksınız? (Kredi Kartı için 0 Paypal için 1 giriniz)
0
Ödenecek miktarı giriniz:
250
250.0 TL Kredi Kartı ile ödendi
Tekrar denemek istiyor musunuz?(Evet/Hayır)
Hayır
```

## Author

Sermed Kerim
