package model.entities;

import java.util.Date;
import java.util.List;

public class Contract {

    private final Integer contractNumber;
    private final Date contractDate;
    private final Double totalValue;

    public Contract(Integer contractNumber, Date contractDate, Double totalValue) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.totalValue = totalValue;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Date getContractDate() {
        return contractDate;
    }
}
