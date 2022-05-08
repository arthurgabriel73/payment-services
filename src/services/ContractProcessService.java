package services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContractProcessService {

    private final Integer installmentQuantity;
    private final Contract contract;
    private final PaymentService paymentService;
    public List<Installment> installmentList = new ArrayList<>();
    Installment updatedInstallment;

    public ContractProcessService(Contract contract, Integer installmentQuantity, PaymentService paymentService) {
        this.contract = contract;
        this.installmentQuantity = installmentQuantity;
        this.paymentService = paymentService;
        this.generateInstallments();
    }

    public void generateInstallments() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(contract.getContractDate());
        double basicInstallment = contract.getTotalValue()/this.installmentQuantity;

        for(int i = 1; i<=installmentQuantity; i++) {
            cal.add(Calendar.MONTH, 1);
            Date dueDate = cal.getTime();

            updatedInstallment = new Installment(dueDate, (basicInstallment + paymentService.interest(basicInstallment) * i
            + paymentService.paymentTax(basicInstallment+ paymentService.interest(basicInstallment) * i)));

            installmentList.add(updatedInstallment);
       }
    }
}