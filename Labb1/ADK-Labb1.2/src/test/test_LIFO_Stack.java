package test;
import se.kth.id1020.labb2.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test_LIFO_Stack<E> {
    int sizeOne; 
    E nullStack[];
    E nullEllement = null;

    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        sizeOne = 1;
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testPushNullElement() {
        System.out.print("Test for when a null element is pushed"+"\n");
        boolean expResult = true;
        boolean result =  assertEquals();
        
    }
    
    @Test
    void testSizeOfStackWithoutElement(){
        
         }

}
