package complex_and_matrices;

/**
 * Parent class for real and complex numbers
 */
public abstract class Number {
    /**
     * Sum operation
     * @param addition is adding up with source number
     * @return sum of two numbers
     **/
    public abstract Number add(Number addition);
    /**
     * Multiply operation
     * @param multiplier is multiplied by source number
     * @return multiplication of two numbers
     **/
    public abstract Number multiply(Number multiplier);
}
