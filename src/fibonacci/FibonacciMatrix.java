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
public class FibonacciMatrix {
    private final BigInteger[][] cells = new BigInteger[2][2];
    
    private FibonacciMatrix() {
        
    }
    
    public FibonacciMatrix(BigInteger fib0, BigInteger fib1) {
        cells[0][0] = fib0;
        cells[1][0] = fib1;
        cells[0][1] = fib1;
        cells[1][1] = fib0.add(fib1);
    }
    
    
    public FibonacciMatrix multiply(FibonacciMatrix other) {
        FibonacciMatrix multiple = new FibonacciMatrix();
        for (int i = 0; i<2; i++) {
            for (int j = 0; j<2; j++) {
                multiple.cells[i][j] = cells[i][0].multiply(other.cells[0][j]).add(cells[i][1].multiply(other.cells[1][j]));
            }
        }
        return multiple;
    }
    
    @Override
    public String toString() {
        return cells[0][0]+","+cells[0][1]+"\n"+cells[1][0]+","+cells[1][1];
    }
}
