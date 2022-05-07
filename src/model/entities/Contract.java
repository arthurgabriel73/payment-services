package model.entities;

import java.util.Date;
import java.util.List;

public class Contract {

    private Integer contractNumber;
    private Date contractDate;
    private Double totalValue;

    public Contract(Integer contractNumber, Date contractDate, Double totalValue) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.totalValue = totalValue;
    }

    public Double getTotalValue() {
        return totalValue;
    }
}
