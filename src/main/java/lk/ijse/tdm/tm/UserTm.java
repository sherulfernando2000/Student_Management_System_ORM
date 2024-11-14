package lk.ijse.tdm.tm;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserTm {
    @Id
    private String userName;

    private String password;
    private String role;
    private String email;

    public UserTm() {
    }

    public UserTm(String userName, String password, String role, String email) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
