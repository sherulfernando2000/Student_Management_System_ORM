package lk.ijse.tdm.tm;

public class CartTm {
    String Id;
    String name;
    double Fee;
    double upfrontpayment;

    public CartTm() {
    }

    public CartTm(String id, String name, double fee, double upfrontpayment) {
        Id = id;
        this.name = name;
        Fee = fee;
        this.upfrontpayment = upfrontpayment;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double fee) {
        Fee = fee;
    }

    public double getUpfrontpayment() {
        return upfrontpayment;
    }

    public void setUpfrontpayment(double upfrontpayment) {
        this.upfrontpayment = upfrontpayment;
    }
}
