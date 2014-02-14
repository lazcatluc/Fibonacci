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
public class FibonacciBigInteger implements Fibonacciable<FibonacciBigInteger> {

    private final BigInteger myBigInteger;
    
    public FibonacciBigInteger(BigInteger myBigInteger) {
        this.myBigInteger = myBigInteger;
    }
    
    @Override
    public FibonacciBigInteger add(FibonacciBigInteger another) {
        return new FibonacciBigInteger(myBigInteger.add(another.myBigInteger));
    }

    @Override
    public FibonacciBigInteger subtract(FibonacciBigInteger another) {
        return new FibonacciBigInteger(myBigInteger.subtract(another.myBigInteger));
    }

    @Override
    public FibonacciBigInteger square() {
        return new FibonacciBigInteger(myBigInteger.pow(2));
    }

    @Override
    public Number getValue() {
        return myBigInteger;
    }
    
}
