package test;
import java.util.Arrays;
 
import static org.junit.Assert.*;
 
import java.util.NoSuchElementException;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import set.ArraySet;
import set.MaxSet;
import set.RemoveDuplicates;
 
 
 
 
public class TestRemoveDuplicates {
    private int[] vektor;
 
    @Before
    public void setUp() throws Exception {
    vektor = new int[3];
    }
 
    @After
    public void tearDown() throws Exception {
        vektor = null;
    }
 
    @Test
    public final void testUniqueElements1(){
        vektor[0]=8;
        vektor[1]=8;
        vektor[2]=8;
        assertEquals("Wrong length: ", 1, RemoveDuplicates.uniqueElements(vektor).length);
    }
     
    @Test
    public final void testUniqueElements2(){
        vektor[0]=2;
        vektor[1]=3;
        vektor[2]=1;
        assertEquals("Wrong number: ", 1, RemoveDuplicates.uniqueElements(vektor)[0]);
        assertEquals("Wrong number: ", 2, RemoveDuplicates.uniqueElements(vektor)[1]);
        assertEquals("Wrong number: ", 3, RemoveDuplicates.uniqueElements(vektor)[2]);
    }
}