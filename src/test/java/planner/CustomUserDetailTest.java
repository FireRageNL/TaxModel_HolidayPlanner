/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author roy_v
 */
public class CustomUserDetailTest {
    Login temp;
    public CustomUserDetailTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        temp = new Login();
        temp.setPassWord("testp");
        temp.setUserName("testu");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthorities method, of class CustomUserDetail.
     */
    @Test
    public void testGetAuthorities() {
        System.out.println("getAuthorities");
        CustomUserDetail instance = new CustomUserDetail(temp);
        Collection<? extends GrantedAuthority> expResult = AuthorityUtils.createAuthorityList("user");
        Collection<? extends GrantedAuthority> result = instance.getAuthorities();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class CustomUserDetail.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        CustomUserDetail instance = new CustomUserDetail(temp);
        String expResult = "testp";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class CustomUserDetail.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        CustomUserDetail instance = new CustomUserDetail(temp);
        String expResult = "testu";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAccountNonExpired method, of class CustomUserDetail.
     */
    @Test
    public void testIsAccountNonExpired() {
        System.out.println("isAccountNonExpired");
        CustomUserDetail instance = new CustomUserDetail(temp);
        boolean expResult = true;
        boolean result = instance.isAccountNonExpired();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAccountNonLocked method, of class CustomUserDetail.
     */
    @Test
    public void testIsAccountNonLocked() {
        System.out.println("isAccountNonLocked");
        CustomUserDetail instance = new CustomUserDetail(temp);
        boolean expResult = true;
        boolean result = instance.isAccountNonLocked();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCredentialsNonExpired method, of class CustomUserDetail.
     */
    @Test
    public void testIsCredentialsNonExpired() {
        System.out.println("isCredentialsNonExpired");
        CustomUserDetail instance = new CustomUserDetail(temp);
        boolean expResult = true;
        boolean result = instance.isCredentialsNonExpired();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEnabled method, of class CustomUserDetail.
     */
    @Test
    public void testIsEnabled() {
        System.out.println("isEnabled");
        CustomUserDetail instance = new CustomUserDetail(temp);
        boolean expResult = true;
        boolean result = instance.isEnabled();
        assertEquals(expResult, result);
    }

}
