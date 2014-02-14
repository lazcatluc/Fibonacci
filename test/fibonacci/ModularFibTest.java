/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

import java.math.BigInteger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Catalin
 */
public class ModularFibTest extends FibonacciTest {

    @Override
    protected void assertExpectedFibonacci(Number expectedFibonacci, int n) {
        ComputeFibonacci computeFibonacci = new ComputeFibonacci(n, new ModularFib(0, 222), new ModularFib(1, 222));
        computeFibonacci.compute();
        
        assertEquals(expectedFibonacci, computeFibonacci.getMatrix().getFibonacciNumber());
    }    

    /**
     * 573147844013817084101 % 222 = 137
     */
    @Override
    @Test
    public void fib100is573147844013817084101() {
       assertExpectedFibonacci(BigInteger.valueOf(137), 100);
    }
    
    @Test
    public void fib1000000000is37() {
        assertExpectedFibonacci(BigInteger.valueOf(37), 1000000000);
    }
    
}
