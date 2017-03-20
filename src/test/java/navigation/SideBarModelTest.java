/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Violet
 */
public class SideBarModelTest {
    
    SideBarModel instance;
    
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
        instance = new SideBarModel("Violet", "/Tilburg");
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
        String Location = "/Bemmel";
        instance.setLocation(Location);
        assertEquals(Location, instance.getLocation());
    }

    /**
     * Test of getLocation method, of class SideBarModel.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        String expResult = "/Tilburg";
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class SideBarModel.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Violet";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class SideBarModel.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String Name = "Roy";
        instance.setName(Name);
        assertEquals(Name, instance.getName());
    }
    
}
