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
public class ModularFib implements Fibonacciable<ModularFib> {

    private final Integer myInt;
    private final Integer module;

    public ModularFib(Integer myInt, Integer module) {
        this.myInt = myInt;
        this.module = module;
    }    
    
    @Override
    public ModularFib add(ModularFib another) {
        return new ModularFib((myInt + another.myInt) % module, module);
    }

    @Override
    public ModularFib subtract(ModularFib another) {
        Integer diff = myInt - another.myInt;
        Integer mod = diff % module;
        if (mod < 0) {
            mod += module;
        }
        
        return new ModularFib(mod, module);
    }

    @Override
    public ModularFib square() {
        return new ModularFib((myInt * myInt) % module, module);
    }

    @Override
    public Number getValue() {
        return BigInteger.valueOf(myInt);
    }
    
}
