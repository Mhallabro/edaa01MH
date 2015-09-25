package testqueue;
 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import queue.FifoQueue;
 
public class TestAppendFifoQueue {
    private FifoQueue<Integer> fifo1;
    private FifoQueue<Integer> fifo2;
 
    @Before
    public void setUp() throws Exception {
    	fifo1 = new FifoQueue<Integer>();
    	fifo2 = new FifoQueue<Integer>();
    }
 
    @After
    public void tearDown() throws Exception {
        fifo1 = null;
        fifo2 = null;
    }
    
    @Test
    public final void testAppendFifoQueue1(){
    	fifo1.offer(1);
        fifo2.offer(1);
        fifo1.append(fifo2);
        assertTrue("Wrong... ", fifo1.size()==2);
    }
    
    @Test
    public final void testAppendFifoQueue2(){
        fifo1.offer(1);
        fifo1.append(fifo2);
        assertTrue("Wrong... ", fifo1.size()==1);
    }
    
    @Test
    public final void testAppendFifoQueue3(){
        fifo2.offer(1);
        fifo1.append(fifo2);
        assertTrue("Wrong... ", fifo1.size()==1);
    }
    
    @Test
    public final void testAppendFifoQueue4(){
        fifo1.append(fifo2);
        assertTrue("Wrong... ", fifo1.size()==0);
    }
    
}