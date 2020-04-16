/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class GoFishTest {
    
    public GoFishTest() {
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
     * Test of draw method, of class GoFish.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Card expResult = null;
        Card result = GoFish.draw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deckSize method, of class GoFish.
     */
    @Test
    public void testDeckSize() {
        System.out.println("deckSize");
        int expResult = 52;
        int result = GoFish.deckSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class GoFish.
     */
    /*@Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GoFish.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    
    
}
