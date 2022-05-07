package application;

import model.entities.Contract;
import services.ContractProcessService;

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
        Date contractDate = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        System.out.print("Enter number of installments: ");
        int installmentQuantity = sc.nextInt();
        ContractProcessService contractProcessService = new ContractProcessService(new Contract(contractNumber, contractDate, contractValue),installmentQuantity);

        System.out.println("Installments: ");
    }
}
