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
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FibonacciMatrix matrix = new FibonacciMatrix(BigInteger.ONE, BigInteger.ONE);
        System.out.println(matrix.multiply(matrix).multiply(matrix).multiply(matrix));
    }
    
}
