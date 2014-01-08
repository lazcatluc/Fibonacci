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
    public static int n = 40000000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        long millis = System.currentTimeMillis();
        ComputeFibonacci computeFib = new ComputeFibonacci(n);
        computeFib.compute();
        System.out.print((System.currentTimeMillis() - millis) / 1000);
        System.out.println(" seconds"); 
    }
    
    
}
