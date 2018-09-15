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
public class SimpleLinkedListTest {
    
    public SimpleLinkedListTest() {
        
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
    public void testAdd() {
        SimpleLinkeList<String> instance = new SimpleLinkeList<String>();
        instance.add("One");
        instance.add("Two");
        instance.add("Three");
        assertEquals(instance.size(), 3);
        assertEquals("One", instance.get(0));
        assertEquals("Two", instance.get(1));
        assertEquals("Three", instance.get(2));
        assertEquals("Three", instance.remove(2));
        assertEquals("Two", instance.remove(1));
        assertEquals("One", instance.remove(0));
        
        assertEquals(instance.size(), 0);
        
        instance.add("One");
        instance.add("Two");
        instance.add("Three");
        
        assertEquals(instance.size(), 3);
        
        assertEquals(true, instance.remove("Two"));
        assertEquals("Three", instance.get(1));
        assertEquals(true, instance.remove("Three"));
        assertEquals("One", instance.get(0));
        assertEquals(true, instance.remove("One"));
        assertEquals(false, instance.remove("Four"));
        
        assertEquals(instance.size(), 0);
        
    }
    
    @Test
    public void testDouble() {
        DoublyLinkedList<String> instance = new DoublyLinkedList<String>();
        instance.insert("One");
        instance.insert("Two");
        instance.insert("Three");
        assertEquals(instance.getSize(), 3);
        assertEquals("One", instance.get(0));
        assertEquals("Two", instance.get(1));
        assertEquals("Three", instance.get(2));
        assertEquals("Three", instance.remove(2));
        assertEquals("Two", instance.remove(1));
        assertEquals("One", instance.remove(0));
        
        assertEquals(instance.getSize(), 0);
        
        instance.add("One");
        instance.add("Two");
        instance.add("Three");
        
        assertEquals(instance.getSize(), 3);
        
        assertEquals(true, instance.remove("Two"));
        assertEquals("Three", instance.get(1));
        assertEquals(true, instance.remove("Three"));
        assertEquals("One", instance.get(0));
        assertEquals(true, instance.remove("One"));
        assertEquals(false, instance.remove("Four"));
        
        assertEquals(instance.size(), 0);
        
    }
    
    
    
    
}
