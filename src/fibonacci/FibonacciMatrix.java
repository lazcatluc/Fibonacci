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

/**
 *
 * @author Catalin
 */
public class FibonacciMatrix<T extends Fibonacciable<T>> {
    private final Fibonacciable[][] cells = new Fibonacciable[2][2];
    
    public FibonacciMatrix(T fib0, T fib1) {
        cells[0][0] = fib0;
        cells[1][0] = fib1;
        cells[0][1] = fib1;
        cells[1][1] = fib0.add(fib1);
    }
    
    public FibonacciMatrix square() {
        final Fibonacciable<T> aSquare = cells[0][0].square();
        return new FibonacciMatrix(aSquare.add((T)cells[0][1].square()),
            cells[1][1].square().subtract(aSquare));
    }
    
    public FibonacciMatrix multiplyByZeroOne() {
        return new FibonacciMatrix(cells[0][1], cells[1][1]);
    }
    
    public Number getFibonacciNumber() {
        return cells[1][1].getValue();
    }

}
