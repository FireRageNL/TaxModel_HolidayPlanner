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
public class RoleModelTest {
    RoleModel testRoleModel;
    public RoleModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testRoleModel = new RoleModel(1L,"TestRoleModel",new HashSet<>());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class RoleModel.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1L;
        Long result = testRoleModel.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class RoleModel.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 2L;
        testRoleModel.setId(id);
        assertEquals(id, testRoleModel.getId());
    }

    /**
     * Test of getName method, of class RoleModel.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "TestRoleModel";
        String result = testRoleModel.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class RoleModel.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "NootNoot";
        testRoleModel.setName(name);
        assertEquals(name,testRoleModel.getName());
    }

    /**
     * Test of getUsers method, of class RoleModel.
     */
    @Test
    public void testGetUsers() {
        assertNotNull(testRoleModel.getUsers());
    }

    /**
     * Test of setUsers method, of class RoleModel.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        Set<LoginModel> users = null;
        RoleModel instance = new RoleModel();
        instance.setUsers(users);
        assertNull(instance.getUsers());
    }
    
}
