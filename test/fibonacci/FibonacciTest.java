/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Catalin
 */
public class FibonacciTest {
    
    protected void assertExpectedFibonacci(BigInteger expectedFibonacci, int n) {
        ComputeFibonacci computeFibonacci = new ComputeFibonacci(n);
        computeFibonacci.compute();
        
        assertEquals(expectedFibonacci, computeFibonacci.getFibonacciNumber());
    }
    
    /**
     * Test of main method, of class Fibonacci.
     */
    @Test
    public void fib1is1() {
        assertExpectedFibonacci(BigInteger.ONE, 1);
    }
    
    @Test
    public void fib2is2() {
        assertExpectedFibonacci(BigInteger.valueOf(2), 2);
    }
    
    @Test
    public void fib3is3() {
        assertExpectedFibonacci(BigInteger.valueOf(3), 3);
    }
    
    @Test
    public void fib4is5() {
        assertExpectedFibonacci(BigInteger.valueOf(5), 4);
    }
    
    @Test
    public void fib5is8() {
        assertExpectedFibonacci(BigInteger.valueOf(8), 5);
    }
    
    @Test
    public void fib6is13() {
        assertExpectedFibonacci(BigInteger.valueOf(13), 6);
    }
    
    @Test
    public void fib100is573147844013817084101() {
        assertExpectedFibonacci(new BigInteger("573147844013817084101"), 100);
    }
}
