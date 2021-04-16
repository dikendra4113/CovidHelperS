package com.example.covidhelper;

public class VaccineModal {
    private int zero;

    private String state;
    private int total_vac;

    public VaccineModal(){
    }
    public VaccineModal( int totalvacc,String state) {
        this.total_vac = totalvacc;
        this.state = state;
    }

    public int getZero() {
        return zero;
    }

    public String getState() {
        return state;
    }

    public int getTotal_vac() {
        return total_vac;
    }

    public void setZero(int zero) {
        this.zero = zero;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTotal_vac(int total_vac) {
        this.total_vac = total_vac;
    }
}