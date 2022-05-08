package services;

public class PayPalService implements PaymentService{

    public PayPalService() {
    }

    public double interest(double amount){
        return amount*0.01;
    }
    public double paymentTax(double amount){
        return amount*0.02;
    }
}
