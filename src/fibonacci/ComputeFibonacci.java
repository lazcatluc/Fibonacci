package fibonacci;

import java.math.BigInteger;

/**
 *
 * @author Catalin
 */
public class ComputeFibonacci {
    private FibonacciMatrix matrix;
    private final Fibonacciable zero, one;
    
    private final long power;
    
    public ComputeFibonacci(long count) {
        this.power = count;
        zero = new FibonacciBigInteger(BigInteger.ZERO);
        one = new FibonacciBigInteger(BigInteger.ONE);
    }
    
    public ComputeFibonacci(long count, Fibonacciable zero, Fibonacciable one) {
        this.power = count;
        this.zero = zero;
        this.one = one;
    }
    
    public void compute() {
        matrix = new FibonacciMatrix(zero, one);
        if (power > 1) {
            ComputeFibonacci compRec = new ComputeFibonacci(power / 2, zero, one);
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
