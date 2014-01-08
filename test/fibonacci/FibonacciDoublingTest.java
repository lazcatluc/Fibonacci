/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

import java.math.BigInteger;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Catalin
 */
public class FibonacciDoublingTest extends FibonacciTest {

    @Override
    protected void assertExpectedFibonacci(BigInteger expectedFibonacci, int n) {
        assertEquals(expectedFibonacci, FibonacciDoubling.getFibonacciNumber(n));
    }
    
}
