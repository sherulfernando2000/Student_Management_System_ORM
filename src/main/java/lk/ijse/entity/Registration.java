package lk.ijse.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Registration {
    @Id
   private String rId;

    //private String sId;
    @ManyToOne
    private Student student;

    //private String pId;
    @ManyToOne
    private Program program;
   private double upfrontpayment;

   @ManyToOne
   private Payment payment;
   private Date date;
//   private double totalPayment;

    public Registration() {
    }

    public Registration(String rId, Student student, Program program, double upfrontpayment, Payment payment, Date date /*,double totalPayment*/) {
        this.rId = rId;
        this.student = student;
        this.program = program;
        this.upfrontpayment = upfrontpayment;
        this.payment = payment;
        this.date = date;
//        this.totalPayment = totalPayment;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public double getUpfrontpayment() {
        return upfrontpayment;
    }

    public void setUpfrontpayment(double upfrontpayment) {
        this.upfrontpayment = upfrontpayment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /* public Registration(String rId, String sId, String pId, double upfrontpayment, Date date, double totalPayment) {
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
    }*/
}
