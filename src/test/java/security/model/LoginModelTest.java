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
    LoginModel test;

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
        test = new LoginModel("abcd","test",1);
        test.setIdUser(1L);
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
        String expResult = "test";
        String result = test.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class LoginModel.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "testing";
        test.setUserName(userName);
        assertEquals("testing", test.getUserName());
    }

    /**
     * Test of getPassWord method, of class LoginModel.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        String expResult = "abcd";
        String result = test.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassWord method, of class LoginModel.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "bbbb";
        test.setPassWord(passWord);
        assertEquals("bbbb", test.getPassWord());
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
    @Test
    public void customConstructorTest2(){
        System.out.println("Custom constructor taking a login object");
        LoginModel secondTest = new LoginModel(test);
        String password = "abcd";
        String username = "test";
        assertEquals(password,secondTest.getPassWord());
        assertEquals(username,secondTest.getUserName());
    }
    /**
     * Test of getRoles method, of class LoginModel.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        LoginModel instance = test;
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
        test.setRoles(roles);
        assertNull(test.getRoles());
    }

    /**
     * Test of getDaysOff method, of class LoginModel.
     */
    @Test
    public void testGetDaysOff() {
        System.out.println("getDaysOff");
        int expResult = 1;
        int result = test.getDaysOff();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDaysOff method, of class LoginModel.
     */
    @Test
    public void testSetDaysOff() {
        System.out.println("setDaysOff");
        int daysOff = 50;
        test.setDaysOff(daysOff);
        assertEquals(daysOff, test.getDaysOff());
    }

    /**
     * Test of getPasswordVerify method, of class LoginModel.
     */
    @Test
    public void testGetPasswordVerify() {
        System.out.println("getPasswordVerify");
        String expResult = null;
        String result = test.getPasswordVerify();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPasswordVerify method, of class LoginModel.
     */
    @Test
    public void testSetPasswordVerify() {
        System.out.println("setPasswordVerify");
        String passwordVerify = "testing";
        test.setPasswordVerify(passwordVerify);
        assertEquals(passwordVerify, test.getPasswordVerify());
    }

    /**
     * Test of getIDUser method, of class LoginModel.
     */
    @Test
    public void testGetIDUser() {
        System.out.println("getIDUser");
        Long expResult = 1L;
        Long result = test.getIdUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIDUser method, of class LoginModel.
     */
    @Test
    public void testSetIDUser() {
        System.out.println("setIDUser");
        Long idUser = 2L;
        test.setIdUser(idUser);
        assertEquals(idUser,test.getIdUser());
    }


}
