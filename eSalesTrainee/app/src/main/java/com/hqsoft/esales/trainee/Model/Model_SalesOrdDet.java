package com.hqsoft.esales.trainee.Model;

public class Model_SalesOrdDet {
    String OrderNbr,LineRef,InvtID,LineAmt,LineQty;

    public Model_SalesOrdDet(String orderNbr, String lineRef, String invtID, String lineAmt, String lineQty) {
        OrderNbr = orderNbr;
        LineRef = lineRef;
        InvtID = invtID;
        LineAmt = lineAmt;
        LineQty = lineQty;
    }

    public Model_SalesOrdDet() {
    }

    public String getOrderNbr() {
        return OrderNbr;
    }

    public void setOrderNbr(String orderNbr) {
        OrderNbr = orderNbr;
    }

    public String getLineRef() {
        return LineRef;
    }

    public void setLineRef(String lineRef) {
        LineRef = lineRef;
    }

    public String getInvtID() {
        return InvtID;
    }

    public void setInvtID(String invtID) {
        InvtID = invtID;
    }

    public String getLineAmt() {
        return LineAmt;
    }

    public void setLineAmt(String lineAmt) {
        LineAmt = lineAmt;
    }

    public String getLineQty() {
        return LineQty;
    }

    public void setLineQty(String lineQty) {
        LineQty = lineQty;
    }
}
