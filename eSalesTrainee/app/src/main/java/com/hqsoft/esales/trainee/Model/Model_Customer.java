package com.hqsoft.esales.trainee.Model;

public class Model_Customer {
    String cusId,cusName,cusAddress,cusSdt;

    public Model_Customer(String cusId, String cusName, String cusAddress, String cusSdt) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusSdt = cusSdt;
    }

    public Model_Customer() {
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusSdt() {
        return cusSdt;
    }

    public void setCusSdt(String cusSdt) {
        this.cusSdt = cusSdt;
    }
}
