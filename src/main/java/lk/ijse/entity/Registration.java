package lk.ijse.entity;

import java.util.Date;

public class Registration {

   private String rId;
   private String sId;
   private String pId;
   private double upfrontpayment;
   private Date date;
   private double totalPayment;

    public Registration() {
    }

    public Registration(String rId, String sId, String pId, double upfrontpayment, Date date, double totalPayment) {
        this.rId = rId;
        this.sId = sId;
        this.pId = pId;
        this.upfrontpayment = upfrontpayment;
        this.date = date;
        this.totalPayment = totalPayment;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public double getUpfrontpayment() {
        return upfrontpayment;
    }

    public void setUpfrontpayment(double upfrontpayment) {
        this.upfrontpayment = upfrontpayment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
