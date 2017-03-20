/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.model;

import java.util.HashSet;
import java.util.Set;
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
public class LoginModelTest {

    public LoginModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class LoginModel.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        LoginModel test = new LoginModel();
        test.setPassWord("aaaa");
        test.setUserName("user");
        LoginModel instance = new LoginModel(test);
        String expResult = "user";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class LoginModel.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "test";
        LoginModel instance = new LoginModel();
        instance.setUserName(userName);
        assertEquals("test", instance.getUserName());
    }

    /**
     * Test of getPassWord method, of class LoginModel.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        LoginModel test = new LoginModel();
        test.setPassWord("aaaa");
        test.setUserName("user");
        LoginModel instance = new LoginModel(test);
        String expResult = "aaaa";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassWord method, of class LoginModel.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "bbbb";
        LoginModel instance = new LoginModel();
        instance.setPassWord(passWord);
        assertEquals("bbbb", instance.getPassWord());
    }

    @Test
    public void customConstructorTest() {
        System.out.println("Custom constructor test");
        LoginModel instance = new LoginModel("testpw", "testuser", 1);
        String password = "testpw";
        String username = "testuser";
        assertEquals(password, instance.getPassWord());
        assertEquals(username, instance.getUserName());
    }

    /**
     * Test of getRoles method, of class LoginModel.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        LoginModel instance = new LoginModel();
        Set<RoleModel> expResult = new HashSet<>();
        expResult.add(new RoleModel());
        instance.setRoles(expResult);
        Set<RoleModel> result = instance.getRoles();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoles method, of class LoginModel.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
        Set<RoleModel> roles = null;
        LoginModel instance = new LoginModel();
        instance.setRoles(roles);
        assertNull(instance.getRoles());
    }

    /**
     * Test of getDaysOff method, of class LoginModel.
     */
    @Test
    public void testGetDaysOff() {
        System.out.println("getDaysOff");
        LoginModel instance = new LoginModel();
        int expResult = 0;
        int result = instance.getDaysOff();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDaysOff method, of class LoginModel.
     */
    @Test
    public void testSetDaysOff() {
        System.out.println("setDaysOff");
        int daysOff = 50;
        LoginModel instance = new LoginModel();
        instance.setDaysOff(daysOff);
        assertEquals(daysOff, instance.getDaysOff());
    }

    /**
     * Test of getPasswordVerify method, of class LoginModel.
     */
    @Test
    public void testGetPasswordVerify() {
        System.out.println("getPasswordVerify");
        LoginModel instance = new LoginModel();
        String expResult = null;
        String result = instance.getPasswordVerify();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPasswordVerify method, of class LoginModel.
     */
    @Test
    public void testSetPasswordVerify() {
        System.out.println("setPasswordVerify");
        String passwordVerify = "testing";
        LoginModel instance = new LoginModel();
        instance.setPasswordVerify(passwordVerify);
        assertEquals(passwordVerify, instance.getPasswordVerify());
    }

}
