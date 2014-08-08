package com.home.work.home_expenses.domain;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Created by Bharath on 12-05-2014.
 */
@JsonDeserialize
public class Period {

    private String month;

    private String year;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
