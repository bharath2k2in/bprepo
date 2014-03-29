package com.home.work.home_expenses.domain;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Bharath on 28-03-2014.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ExpenseDetail {

    @XmlAttribute(required = true)
    protected int amount;

    @XmlAttribute(required = true)
    protected String description;

    @XmlAttribute(required = true)
    protected String category;

    public ExpenseDetail() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
