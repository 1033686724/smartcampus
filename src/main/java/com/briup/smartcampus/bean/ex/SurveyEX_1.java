package com.briup.smartcampus.bean.ex;

import java.io.Serializable;

public class SurveyEX_1 implements Serializable {
    private String claName;

    private double average;

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
