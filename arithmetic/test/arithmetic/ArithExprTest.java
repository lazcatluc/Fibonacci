/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arithmetic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import static junit.framework.Assert.*;
import org.junit.Test;

/**
 *
 * @author Catalin
 */
public class ArithExprTest {
    
    public ArithExprTest() {
    }

    @Test
    public void test1() throws java.lang.Exception {
        assertArithExprOutputsClosestMatch("4089", 3972, 87, 5, 47);
    }
    
    @Test
    public void test2() throws java.lang.Exception {
        assertArithExprOutputsClosestMatch("119", 119, 3, 5, 17, 37, 61, 87);
    }
    
    @Test
    public void test3() throws java.lang.Exception {
        assertArithExprOutputsClosestMatch("422", 424, 17, 19, 23, 29, 31);
    }
    
    @Test
    public void test4() throws java.lang.Exception {
        assertArithExprOutputsClosestMatch("256954", 256952, 5, 7, 11, 17, 47, 67, 71);
    }
    
    @Test
    public void testPerformance() throws Exception {
        final int len = 25;
        Integer[] hundred = new Integer[len];
        for (int i = 0; i < len; i++) {
            hundred[i] = i;
        }
        
        assertArithExprOutputsClosestMatch("12345", 12345, hundred);
    }
    
    public void assertArithExprOutputsClosestMatch(String expectedValue, int target, Integer... numbersInExpresion) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        ArithExpr.produceArithExpr(new ArrayList<>(Arrays.asList(numbersInExpresion)), target);
        assertEquals(expectedValue, baos.toString().trim());
    }
}
