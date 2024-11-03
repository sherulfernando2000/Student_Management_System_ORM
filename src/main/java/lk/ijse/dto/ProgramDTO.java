package lk.ijse.dto;

public class ProgramDTO {
    String pId;
    String pName;
    String duration;
    double fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String pId, String pName, String duration, double fee) {
        this.pId = pId;
        this.pName = pName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDuration() {
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
