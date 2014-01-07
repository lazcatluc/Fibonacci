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
public class ComputeFibonacci {
    private FibonacciMatrix matrix = new FibonacciMatrix(BigInteger.ZERO, BigInteger.ONE);
    
    private final int power;
    
    public ComputeFibonacci(int count) {
        this.power = count;
    }
    
    public void compute() {
        if (power > 1) {
            ComputeFibonacci compRec = new ComputeFibonacci(power / 2);
            compRec.compute();
            matrix = compRec.matrix.multiply(compRec.matrix);
            if (power % 2 == 1) {
                matrix = matrix.multiply(new FibonacciMatrix(BigInteger.ZERO, BigInteger.ONE));
            }
        }
    }
    
    public BigInteger getFibonacciNumber() {
        return matrix.getFibonacciNumber();
    }
}
