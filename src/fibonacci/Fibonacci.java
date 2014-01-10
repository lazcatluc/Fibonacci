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
    public static int n = 50000000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        long millis = System.currentTimeMillis();
        ComputeFibonacci computeFib = new ComputeFibonacci(n);
        computeFib.compute();
        long first = System.currentTimeMillis();
        System.out.print((first - millis) / 1000);
        System.out.println(" seconds"); 
        
        FibonacciDoubling.getFibonacciNumber(n);
        long second = System.currentTimeMillis() - first;
        System.out.print(second / 1000);
        System.out.println(" seconds"); 
    }
}
