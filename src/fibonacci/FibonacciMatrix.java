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

/**
 *
 * @author Catalin
 */
public class FibonacciMatrix {
    private final BigInteger[][] cells = new BigInteger[2][2];
    
    public FibonacciMatrix(BigInteger fib0, BigInteger fib1) {
        cells[0][0] = fib0;
        cells[1][0] = fib1;
        cells[0][1] = fib1;
        cells[1][1] = fib0.add(fib1);
    }
    
    public FibonacciMatrix square() {
        final BigInteger aSquare = cells[0][0].pow(2);
        return new FibonacciMatrix(aSquare.add(cells[0][1].pow(2)),
            cells[1][1].pow(2).subtract(aSquare));
    }
    
    public FibonacciMatrix multiplyByZeroOne() {
        return new FibonacciMatrix(cells[0][1], cells[1][1]);
    }
    
    public BigInteger getFibonacciNumber() {
        return cells[1][1];
    }

}
