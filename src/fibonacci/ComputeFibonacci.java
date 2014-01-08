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
public class ComputeFibonacci {
    private FibonacciMatrix matrix;
    
    private final int power;
    
    public ComputeFibonacci(int count) {
        this.power = count;
    }
    
    public void compute() {
        matrix = new FibonacciMatrix(BigInteger.ZERO, BigInteger.ONE);
        if (power > 1) {
            ComputeFibonacci compRec = new ComputeFibonacci(power / 2);
            compRec.compute();
            matrix = compRec.getMatrix().square();
            if (power % 2 == 1) {
                matrix = getMatrix().multiplyByZeroOneOneTwo();
            }
        }
    }
  
    public BigInteger getFibonacciNumber() {
        return getMatrix().getFibonacciNumber();
    }

    @Override
    public String toString() {
        return  getMatrix().toString();
    }

    /**
     * @return the matrix
     */
    public FibonacciMatrix getMatrix() {
        return matrix;
    }
    
}
