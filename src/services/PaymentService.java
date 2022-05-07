package services;

public interface PaymentService {
    double interest(double amount);
    double paymentTax(double amount);
}
