/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roy_v
 */
public class UserTest {

    User testRegister;
    User testUser;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testRegister = new User("testing", "Test", 25);
        testRegister.setPasswordVerify("testing");
        testUser = new User(testRegister);
        testUser.setIdUser(2L);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        User instance = testRegister;
        String expResult = "Test";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "testiing";
        User instance = new User();
        instance.setUserName(userName);
        assertEquals(userName, instance.getUserName());
    }

    /**
     * Test of getPassWord method, of class User.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        User instance = testRegister;
        String expResult = "testing";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassWord method, of class User.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "doesthispasswordwork";
        User instance = new User();
        instance.setPassWord(passWord);
        assertEquals(passWord, instance.getPassWord());
    }

    /**
     * Test of getPasswordVerify method, of class User.
     */
    @Test
    public void testGetPasswordVerify() {
        System.out.println("getPasswordVerify");
        User instance = testRegister;
        String expResult = "testing";
        String result = instance.getPasswordVerify();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPasswordVerify method, of class User.
     */
    @Test
    public void testSetPasswordVerify() {
        System.out.println("setPasswordVerify");
        String passwordVerify = "passverify";
        User instance = new User();
        instance.setPasswordVerify(passwordVerify);
        assertEquals(passwordVerify, instance.getPasswordVerify());
    }

    /**
     * Test of getDaysOff method, of class User.
     */
    @Test
    public void testGetDaysOff() {
        System.out.println("getDaysOff");
        int expResult = 25;
        int result = testRegister.getDaysOff();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDaysOff method, of class User.
     */
    @Test
    public void testSetDaysOff() {
        System.out.println("setDaysOff");
        int daysOff = 30;
        User instance = new User();
        instance.setDaysOff(daysOff);
        assertEquals(daysOff, instance.getDaysOff());
    }

    /**
     * Test of getIdUser method, of class User.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        Long expResult = 2L;
        Long result = testUser.getIdUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdUser method, of class User.
     */
    @Test
    public void testSetIdUser() {
        System.out.println("setIdUser");
        Long idUser = 3L;
        User instance = testRegister;
        instance.setIdUser(idUser);
        assertEquals(idUser, instance.getIdUser());
    }

}
