package lk.ijse.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double upfrontpayment;
    private double balance;

    @OneToOne
    private Registration registration;

    public Payment() {
    }

    public Payment(Integer id, double upfrontpayment, double balance) {
        this.id = id;
        this.upfrontpayment = upfrontpayment;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getUpfrontpayment() {
        return upfrontpayment;
    }

    public void setUpfrontpayment(double upfrontpayment) {
        this.upfrontpayment = upfrontpayment;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
