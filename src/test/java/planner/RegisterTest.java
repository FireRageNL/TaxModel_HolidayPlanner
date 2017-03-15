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
public class RegisterTest {

    Register testRegister;

    public RegisterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testRegister = new Register("Test", "testing", "testing");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class Register.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Register instance = testRegister;
        String expResult = "Test";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class Register.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "testiing";
        Register instance = new Register();
        instance.setUserName(userName);
        assertEquals(userName, instance.getUserName());
    }

    /**
     * Test of getPassWord method, of class Register.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        Register instance = testRegister;
        String expResult = "testing";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassWord method, of class Register.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "doesthispasswordwork";
        Register instance = new Register();
        instance.setPassWord(passWord);
        assertEquals(passWord, instance.getPassWord());
    }

    /**
     * Test of getPasswordVerify method, of class Register.
     */
    @Test
    public void testGetPasswordVerify() {
        System.out.println("getPasswordVerify");
        Register instance = testRegister;
        String expResult = "testing";
        String result = instance.getPasswordVerify();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPasswordVerify method, of class Register.
     */
    @Test
    public void testSetPasswordVerify() {
        System.out.println("setPasswordVerify");
        String passwordVerify = "passverify";
        Register instance = new Register();
        instance.setPasswordVerify(passwordVerify);
        assertEquals(passwordVerify, instance.getPasswordVerify());
    }

}
