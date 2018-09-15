/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shirley
 */
public class LQueueTest {
    
    public LQueueTest() {
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
     * Test of rotate2 method, of class LQueue.
     */
    @Test
    public void testRotate2() {
        LQueue instance = new LQueue<String>();
        instance.enqueue("One");
        instance.enqueue("Two");
        instance.enqueue("Three");
        assertEquals(instance.size(), 3);
        assertEquals(instance.dequeue(), "One");
        assertEquals(instance.dequeue(), "Two");
        assertEquals(instance.dequeue(), "Three");
    }
    
}
