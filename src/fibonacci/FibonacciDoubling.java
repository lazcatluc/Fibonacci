/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Catalin
 */
public class FibonacciDoubling extends RecursiveTask<BigInteger> {
    
    /*
     * A cache of squared fibonacci numbers
     */
    private static BigInteger[] cache;
    private static final BigInteger COMPUTING = BigInteger.valueOf(-1);
    
    private final int power;
    
    public FibonacciDoubling(int power) {
        this.power = power;
    }
    
    public static BigInteger getFibonacciNumber(int n) {
        cache = new BigInteger[n+2];
        cache[0] = BigInteger.ZERO;
        cache[1] = BigInteger.ONE;
        cache[2] = BigInteger.ONE;
        return new ForkJoinPool(100).invoke(new FibonacciDoubling(n+1));
    }
    
    @Override
    public BigInteger compute() {
        if (cache[power] == null) {
            cache[power] = COMPUTING;
            final int halfPower = power/2;
            final FibonacciDoubling halfPowerDoubling = new FibonacciDoubling(halfPower+1);
            halfPowerDoubling.fork();
            BigInteger result;
            if (power % 2 == 0) {
                FibonacciDoubling remainder = new FibonacciDoubling(halfPower-1);
                remainder.fork();
                result = halfPowerDoubling.join().subtract(remainder.join());
            }
            else {
                FibonacciDoubling remainder = new FibonacciDoubling(halfPower);
                remainder.fork();
                result = remainder.join().add(halfPowerDoubling.join());
            }
            if (power < cache.length-1) {
                result = result.pow(2);
            }
            
            cache[power] = result;
        }
        while (COMPUTING == cache[power]) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
        return cache[power];
    }
}
