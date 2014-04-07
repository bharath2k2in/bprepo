package com.home.work.home_expenses.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


/**
 * Created by Bharath on 02-04-2014.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class IncomeExpenseResponse {

    @XmlAttribute(required = true)
    private BigDecimal amount;

    @XmlAttribute(required = true)
    private String description;

    @XmlAttribute(required = true)
    private String category;

    public IncomeExpenseResponse() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

