package model.entities;

import java.util.Date;
import java.util.List;

public class Contract {

    private Integer contractNumber;
    private Date contractDate;
    private Double totalValue;

    private List<Installment> installment;

    public Contract(Integer contractNumber, Date contractDate, Double totalValue) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.totalValue = totalValue;
    }
}
