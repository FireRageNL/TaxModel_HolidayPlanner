package planner;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roy_v
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private Long idUser;
    @Size(min = 3, max = 40, message = "Username is too short or too long")
    @Column(name = "userName")
    private String userName;
    @Size(min=4, message = "The password needs to be at least 4 characters long")
    @Column(name = "passWord")
    private String passWord;
    @NotNull(message = "Please repeat your password")
    @Transient
    private String passwordVerify;
    @Min(value = 1, message = "Please enter a number larger than 1 as days off")
    @Column(name = "daysOff")
    private int daysOff;

    public User() {
        //Empty constructor
    }

    public User(User user) {
        this.daysOff = user.daysOff;
        this.idUser = user.idUser;
        this.passWord = user.passWord;
        this.passwordVerify = user.passwordVerify;
        this.userName = user.userName;
    }

    public User(String passWord, String userName, int daysOff) {
        this.userName = userName;
        this.passWord = passWord;
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

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

}
