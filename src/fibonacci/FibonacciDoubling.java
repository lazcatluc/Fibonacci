/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

import java.math.BigInteger;

/**
 *
 * @author Catalin
 */
public class FibonacciDoubling {
    private final BigInteger[] cache;

    private FibonacciDoubling(int n) {
        cache = new BigInteger[n+2];
        cache[1] = BigInteger.ONE;
        cache[2] = BigInteger.ONE;
    }
    
    public static BigInteger getFibonacciNumber(int n) {
        return new FibonacciDoubling(n).compute(n+1);
    }
    
    private BigInteger compute(int power) {
        if (cache[power] == null) {
            final int halfPower = power/2;
            if (power % 2 == 0) {
                cache[power] = compute(halfPower+1).pow(2).subtract(compute(halfPower-1).pow(2));
            }
            else {
                cache[power] = compute(halfPower).pow(2).add(compute(halfPower+1).pow(2));
            }
        }
        return cache[power];
    }
}
