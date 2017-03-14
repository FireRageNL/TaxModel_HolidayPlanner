package planner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roy_v
 */
public class Register {

    private String userName;
    private String passWord;
    private String passwordVerify;

    public Register(String userName, String passWord, String passwordVerify) {
        this.userName = userName;
        this.passWord = passWord;
        this.passwordVerify = passwordVerify;
    }
    public Register(){
        //Empty constructor
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

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }
    
}
