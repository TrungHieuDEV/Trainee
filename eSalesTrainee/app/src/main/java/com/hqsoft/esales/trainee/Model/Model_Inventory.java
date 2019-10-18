package com.hqsoft.esales.trainee.Model;

public class Model_Inventory {
    String inId,inName,inUnit,inPrice;
    String soLuong="0";

    public Model_Inventory(String inId, String inName, String inUnit, String inPrice) {
        this.inId = inId;
        this.inName = inName;
        this.inUnit = inUnit;
        this.inPrice = inPrice;
    }

    public Model_Inventory(String inId, String inName, String inUnit, String inPrice, String soLuong) {
        this.inId = inId;
        this.inName = inName;
        this.inUnit = inUnit;
        this.inPrice = inPrice;
        this.soLuong = soLuong;
    }

    public Model_Inventory() {
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getInUnit() {
        return inUnit;
    }

    public void setInUnit(String inUnit) {
        this.inUnit = inUnit;
    }

    public String getInPrice() {
        return inPrice;
    }

    public void setInPrice(String inPrice) {
        this.inPrice = inPrice;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }
}
