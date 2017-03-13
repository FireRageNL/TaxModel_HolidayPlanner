package HolidayPlanner;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private Long idUser;
    
    @Column(name = "userName")
    @NotNull
    private String userName;
    
    @Column(name = "passWord")
    @NotNull
    private String passWord;

    public Login() {
    }

    public Login(Login user) {
        this.idUser = user.idUser;
        this.userName = user.userName;
        this.passWord = user.passWord;
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
}
