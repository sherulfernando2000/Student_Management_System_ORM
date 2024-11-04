package lk.ijse.tdm.tm;

public class ProgramTm {
    String id;
    String name;
    String duration;
    double fee;

    public ProgramTm() {
    }

    public ProgramTm(String pId, String pName, String duration, double fee) {
        this.id = pId;
        this.name = pName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String pId) {
        this.id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name= pName;
    }

    public String getDuration () {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
