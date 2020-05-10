package Pachet1;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;


public class MyClassTest {
    MyClass tester = new MyClass();
    int notFound = -1;
    int boudError = -2;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test public void sout(){
        tester.method(new int[]{1}, 0, 3, 3);
        assertEquals("Indicii nu sunt corecti\n", systemOutRule.getLog());
        systemOutRule.clearLog();
        tester.method(new int[]{1}, 0, 0, 1);
        assertEquals("Valoarea a fost gasita la indicele 0\n", systemOutRule.getLog());
        systemOutRule.clearLog();
        tester.method(new int[]{1,2,3,4,5}, 0, 4, 6);
        assertEquals("Valoarea nu a fost gasita in vector\n", systemOutRule.getLog());
        systemOutRule.clearLog();
    }

    @Test public void equvalenceClassesPartitioning() {
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 9, 2, 2));  //L1
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 9, 2));  //L2U1
        assertEquals(notFound,tester.method(new int[]{1,2,3}, 0, 2, 9));   //L2U2K1
        assertEquals(1,tester.method(new int[]{1,2,3}, 0, 2, 2)); //L2U2K2
    }
    
    @Test public void boundry() {
        assertEquals(boudError,tester.method(new int[]{1,2,3}, -1, 2, 2)); //L11
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 1, 2, 2));  //L12
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 1, 2));  //L2U11
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 3, 2));  //L2U12
        assertEquals(notFound,tester.method(new int[]{1,2,3}, 0, 2, 9));   //L2U2K1
        assertEquals(0,tester.method(new int[]{1,2,3}, 0, 2, 1)); //L2U2K21
        assertEquals(2,tester.method(new int[]{1,2,3}, 0, 2, 3)); //L2U2K22
    }

    @Test public void chategoryPartitioning() {
        assertEquals(boudError,tester.method(new int[]{1,2,3}, -3, 0, 0)); //L1
        assertEquals(boudError,tester.method(new int[]{1,2,3}, -1, 0, 0)); //L2
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 0, 0));  //L3U1
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 1, 0));  //L3U2
        assertEquals(notFound,tester.method(new int[]     {}, 0,-1, 0));   //L3U3A1
        assertEquals(0,tester.method(new int[]    {1}, 0, 0, 1)); //L3U3A2K1
        assertEquals(notFound,tester.method(new int[]    {1}, 0, 0, 9));   //L3U3A2K4
        assertEquals(1,tester.method(new int[]{1,2,3}, 0, 2, 2)); //L3U3A3K2
        assertEquals(2,tester.method(new int[]{1,2,3}, 0, 2, 3)); //L3U3A3K3
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 3, 0));  //L3U4
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 0, 5, 0));  //L3U5
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 1, 2, 0));  //L4
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 3, 2, 0));  //L5
    }


    @Test public void statementCoverage() {
        assertEquals(boudError,tester.method(new int[]{1,2,3}, 1, 1, 0));
        assertEquals(0,tester.method(new int[]{1,2,3}, 0, 2, 1));
        assertEquals(notFound,tester.method(new int[]{1,2,3}, 0, 2, 9));
    }
    
    @Test public void decisionCoverage() {
        assertEquals(boudError,tester.method(new int[]{1}, 1, 0, 0));
        assertEquals(notFound,tester.method(new int[]{}, 0, -1, 0));
        assertEquals(0,tester.method(new int[]{1}, 0, 0, 1));
        assertEquals(notFound,tester.method(new int[]{1}, 0, 0, 9));
    }

    @Test public void conditionCoverage() {
        assertEquals(boudError,tester.method(new int[]{1,2}, 1, 1, 0));
        assertEquals(boudError,tester.method(new int[]{1,2}, 0, 0, 0));
        assertEquals(notFound,tester.method(new int[]   {}, 0,-1, 0));
        assertEquals(0,tester.method(new int[]{1,2}, 0, 1, 1));
        assertEquals(notFound,tester.method(new int[]{1,2}, 0, 1, 9));
    }

    @Test
    public void pathCoverage() {
        assertEquals(boudError,tester.method(new int[]{}, 1, 1, 0));
        assertEquals(notFound,tester.method(new int[]{}, 0, -1, 0));
        assertEquals(0,tester.method(new int[]{1}, 0, 0, 1));
        assertEquals(notFound,tester.method(new int[]{1}, 0, 0, 9));
    }
}