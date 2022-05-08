package application;

import model.entities.Contract;
import model.entities.Installment;
import services.ContractProcessService;
import services.PayPalService;
import services.PaymentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the contract data: ");
        System.out.print("Contract Number: ");
        int contractNumber = sc.nextInt();
        System.out.print("Contract date (dd/MM/yyyy): ");
        sc.nextLine();
        Date contractDate = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();
        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Enter number of installments: ");
        int installmentQuantity = sc.nextInt();

        PaymentService PayPalService = new PayPalService();
        ContractProcessService contractProcessService = new ContractProcessService(contract, installmentQuantity, PayPalService);

        System.out.println("Installments: ");
        for(Installment i : contractProcessService.installmentList) {
            System.out.println(sdf.format(i.getDueDate()) + " - " + String.format("%.2f", i.getAmount()));
        }
    }
}
