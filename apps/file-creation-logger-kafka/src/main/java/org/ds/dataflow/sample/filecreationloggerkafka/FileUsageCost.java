package org.ds.dataflow.sample.filecreationloggerkafka;

import java.math.BigDecimal;

public class FileUsageCost {

    private String name;

    private BigDecimal dataCost;

    public FileUsageCost() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDataCost() {
        return dataCost;
    }

    public void setDataCost(BigDecimal dataCost) {
        this.dataCost = dataCost;
    }

    public void setDataCost(String dataCost) {
        this.dataCost = new BigDecimal(dataCost);
    }
}
