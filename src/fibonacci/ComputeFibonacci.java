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
                matrix = getMatrix().multiplyByZeroOne();
            }
        }
    }
    
    /**
     * @return the matrix
     */
    public FibonacciMatrix getMatrix() {
        return matrix;
    }
    
}
