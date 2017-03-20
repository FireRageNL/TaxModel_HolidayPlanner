package security.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private Long idUser;
    @Size(min = 3, max = 40, message = "Username is too short or too long")
    @Column(name = "userName")
    private String userName;
    @Size(min = 4, message = "The password needs to be at least 4 characters long")
    @Column(name = "passWord")
    private String passWord;
    @Transient
    private String passwordVerify;
    @Min(value = 1, message = "Please enter a number larger than 1 as days off")
    @Column(name = "daysOff")
    private int daysOff;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Login() {
        //Empty constructor for JPA
    }

    public Login(Login user) {
        this.idUser = user.idUser;
        this.userName = user.userName;
        this.passWord = user.passWord;
    }

    public Login(String passWord, String userName, int daysOff) {
        this.passWord = passWord;
        this.userName = userName;
        this.daysOff = daysOff;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }
}