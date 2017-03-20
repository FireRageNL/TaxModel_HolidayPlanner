/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import security.model.Login;
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
public class LoginTest {

    public LoginTest() {
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
     * Test of getUserName method, of class Login.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Login test = new Login();
        test.setPassWord("aaaa");
        test.setUserName("user");
        Login instance = new Login(test);
        String expResult = "user";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class Login.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "test";
        Login instance = new Login();
        instance.setUserName(userName);
        assertEquals("test", instance.getUserName());
    }

    /**
     * Test of getPassWord method, of class Login.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        Login test = new Login();
        test.setPassWord("aaaa");
        test.setUserName("user");
        Login instance = new Login(test);
        String expResult = "aaaa";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassWord method, of class Login.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "bbbb";
        Login instance = new Login();
        instance.setPassWord(passWord);
        assertEquals("bbbb",instance.getPassWord());
    }
    @Test
    public void customConstructorTest(){
        System.out.println("Custom constructor test");
        Login instance = new Login("testpw","testuser",1);
        String password = "testpw";
        String username = "testuser";
        assertEquals(password,instance.getPassWord());
        assertEquals(username,instance.getUserName());
    }

}
