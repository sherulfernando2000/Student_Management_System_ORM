package lk.ijse.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private String s_id;
    private String s_name;
    private String address;
    private String contact_no;
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
     List<Registration> registrationList;

    public Student() {
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    /*public Student(String s_id, String s_name, String address, String contact_no, String email) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
    }*/

    public Student(String s_id, String s_name, String address, String contact_no, String email,List<Registration> registrationList) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
        this.registrationList = registrationList;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
