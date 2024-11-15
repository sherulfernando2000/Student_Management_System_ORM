package lk.ijse.tdm.tm;

public class ViewRegiTm {
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private String upforntPay;

    public ViewRegiTm() {
    }

    public ViewRegiTm(String studentId, String studentName, String courseId, String courseName, String upforntPay) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.upforntPay = upforntPay;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUpforntPay() {
        return upforntPay;
    }

    public void setUpforntPay(String upforntPay) {
        this.upforntPay = upforntPay;
    }
}
