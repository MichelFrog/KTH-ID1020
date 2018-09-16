package test;

import se.kth.id1020.labb3.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test_DLinkedList<E> {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    
    @Test
    public void enqueueANumber(){
        DLinkedList<String> Stack = new DLinkedList();
        Stack.enqueue(null);
        assertTrue(Stack.isEmpty());
    }

}
