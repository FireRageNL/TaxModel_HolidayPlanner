/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import security.model.RoleModel;

/**
 *
 * @author Violet
 */
public class SideBarModelTest {
    
    public SideBarModelTest() {
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
     * Test of setLocation method, of class SideBarModel.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String Location = "";
        SideBarModel instance = null;
        instance.setLocation(Location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class SideBarModel.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        SideBarModel instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class SideBarModel.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        SideBarModel instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class SideBarModel.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String Name = "";
        SideBarModel instance = null;
        instance.setName(Name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
