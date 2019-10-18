package com.hqsoft.esales.trainee.Model;

public class Model_SalesOrd {
    String OrderNbr,SlsperID,CustID,OrdAmt,OrdQty,OrderDate,Remark;

    public Model_SalesOrd(String orderNbr, String slsperID, String custID, String ordAmt, String ordQty, String orderDate, String remark) {
        OrderNbr = orderNbr;
        SlsperID = slsperID;
        CustID = custID;
        OrdAmt = ordAmt;
        OrdQty = ordQty;
        OrderDate = orderDate;
        Remark = remark;
    }

    public Model_SalesOrd() {
    }

    public String getOrderNbr() {
        return OrderNbr;
    }

    public void setOrderNbr(String orderNbr) {
        OrderNbr = orderNbr;
    }

    public String getSlsperID() {
        return SlsperID;
    }

    public void setSlsperID(String slsperID) {
        SlsperID = slsperID;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String custID) {
        CustID = custID;
    }

    public String getOrdAmt() {
        return OrdAmt;
    }

    public void setOrdAmt(String ordAmt) {
        OrdAmt = ordAmt;
    }

    public String getOrdQty() {
        return OrdQty;
    }

    public void setOrdQty(String ordQty) {
        OrdQty = ordQty;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
