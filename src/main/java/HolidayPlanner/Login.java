package HolidayPlanner;

import javax.validation.constraints.NotNull;


/**
 *
 * @author Stijn
 */
public class Login {
    
    @NotNull
    private String userName;
    @NotNull
    private String passWord;

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
