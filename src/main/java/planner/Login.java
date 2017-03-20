package planner;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "userName")
    private String userName;

    @Column(name = "passWord")
    private String passWord;

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

    public Login(String passWord, String userName) {
        this.passWord = passWord;
        this.userName = userName;
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
}
