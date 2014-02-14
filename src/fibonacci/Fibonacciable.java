package fibonacci;

/**
 *
 * @author Catalin
 */
public interface Fibonacciable<T extends Fibonacciable> {
    T add(T another);
    T subtract(T another);
    T square();
    Number getValue();
}
