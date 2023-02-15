package complex_and_matrices;

/**
 * Class that implements Real numbers
 */
public class Real extends Number {
    /**
     * Сlass Real is just wrapper for this real value
     * */
    private double a;

    //Constructors
    /**
    * Default constructor that activates user input of a real number
    */
    Real() {
        this.a = 0;
    }
    /**
     * This constructor gets predefined values
     * @param a a to set
     */
    Real(double a) {
        this.a = a;
    }

    //Math operations
    public Number add(Number addition) {
        if (addition instanceof Complex a) {
            return new Complex(this.getA() + a.getA(), a.getB());
        }
        else if (addition instanceof Real a) {
            return new Real(this.getA() + a.getA());
        }
        return new Real();
    }
    public Number multiply(Number multiplier) {
        if (multiplier instanceof Complex m) {
            return new Complex(this.getA() * m.getA(), this.getA() * m.getB());
        }
        else if (multiplier instanceof Real m) {
            return new Real(this.getA() * m.getA());
        }
        return new Real();
    }

    //Getters
    /**
     * @return real value
     */
    public double getA() {
        return a;
    }
    //Setters
    /**
     * @param a a to set
     */
    public void setA(float a) {
        this.a = a;
    }
}
