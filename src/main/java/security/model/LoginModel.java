package security.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class LoginModel implements Serializable {

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
    private Set<RoleModel> roles;

    @OneToMany(mappedBy = "requestor")
    private Set<RequestModel> requests = new HashSet();

    /**
     * Create a new LoginModel.
     *
     */
    public LoginModel() {
        //Empty constructor for JPA
    }

    /**
     * Create a new LoginModel.
     *
     * @param user LoginModel all information will be retrieved from this
     * object.
     */
    public LoginModel(LoginModel user) {
        this.idUser = user.idUser;
        this.userName = user.userName;
        this.passWord = user.passWord;
    }

    /**
     * Create a new LoginModel.
     *
     * @param passWord Password specified by the user (string value). Needs to
     * be at least 4 characters long.
     * @param userName Username specified by the user (string value). Needs to
     * be at least 3 characters long.
     * @param daysOff Days off (int value). Minimal 1 day larger number is also
     * valid.
     */
    public LoginModel(String passWord, String userName, int daysOff) {
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

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
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

    public Long getIDUser() {
        return this.idUser;
    }

    public void setIDUser(Long idUser) {
        this.idUser = idUser;
    }
}
