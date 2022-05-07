package services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContractProcessService {
    private Date contractDate;
    private Integer installmentQuantity;


    private Contract contract;
    private PaymentService paymentService;
    private List<Installment> installmentsList;

    private Double basicInstallment = contract.getTotalValue();

    Calendar cal = Calendar.getInstance();

    public ContractProcessService() {
    }

    public ContractProcessService(Contract contract, Integer installmentQuantity, PaymentService paymentService) {
        this.contract = contract;
        this.installmentQuantity = installmentQuantity;
        this.paymentService = paymentService;
    }

    public ContractProcessService(Contract contract, Integer installmentQuantity) {
        this.contract = contract;
        this.installmentQuantity = installmentQuantity;
    }

    public void generateInstallments() {
        for(int i = 1; i<=installmentQuantity; i++) {

            cal.setTime(contractDate);
            cal.add(Calendar.MONTH, i);
            Date dueDate = cal.getTime();
           Installment updateInstallment = new Installment(dueDate, (basicInstallment + paymentService.interest(basicInstallment) * i));

       }
    }

    public void createInstallmentsList() {

    }
}