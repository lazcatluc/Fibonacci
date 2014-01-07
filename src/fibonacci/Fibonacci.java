/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;

/**
 *
 * @author Catalin
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ComputeFibonacci computeFib = new ComputeFibonacci(3000000);
        computeFib.compute();
        System.out.println(computeFib.getFibonacciNumber());
    }
    
}
