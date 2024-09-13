import java.text.Normalizer;

/**
 * A class that represents a rational number in normal form where the numerator
 * and the denominator share no common factors and only the numerator
 * can be negative.
 * 
 * @author Charles Hoot 
 * @version 4.0
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE

    private int n = 1;
    private int d = 1;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
        // ADD CODE TO THE CONSTRUCTOR
        this.n = 1;
        this.d = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
        // ADD CODE TO THE ALTERNATE CONSTRUCTOR
        this.n = n;
        this.d = d;

        if (d == 0) 
        {
            throw new ZeroDenominatorException("Demoniator is zero, this is not allowed");
        }

        normalize();

    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return this.n;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return this.d;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int newN = -this.n;

        Rational newRational = new Rational(newN,this.d);
        return newRational;
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int newN = this.d;
        int newD = this.n;
        Rational newRational = new Rational(newN,newD);
        return newRational;
    }





    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int firstN = this.n;
        int firstD = this.d;
        int secondN = other.getNumerator();
        int secondD = other.getDenominator();
        Rational newRational = new Rational(firstN*secondD + secondN*firstD,secondD*firstD);
        return newRational;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int firstN = this.n;
        int firstD = this.d;
        int secondN = other.getNumerator();
        int secondD = other.getDenominator();
        Rational newRational = new Rational(firstN*secondD - secondN*firstD,secondD*firstD);
        return newRational;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int firstN = this.n;
        int firstD = this.d;
        int secondN = other.getNumerator();
        int secondD = other.getDenominator();
        Rational newRational = new Rational(firstN*secondN,secondD*firstD);
        return newRational;
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int firstN = this.n;
        int firstD = this.d;
        int secondN = other.getDenominator();
        int secondD = other.getNumerator();
        Rational newRational = new Rational(firstN*secondN,secondD*firstD);
        return newRational;
    }
     
      
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * can be negative.
     *
     */
    private void normalize()
    {
        // ADD CODE TO NORMALIZE THE RATIONAL NUMBER

        if (this.d < 0)
        {
            this.d = -this.d;
            this.n = -this.n;
        }

        int gcd = 0;

        if (this.n < 0)
        {
            int newN = -this.n;
            gcd = gcd(newN,this.d);
        } else {

            gcd = gcd(this.n,this.d);

        }

        this.n = this.n / gcd;
        this.d = this.d / gcd;

    }
    
    /**
     * Recursively compute the greatest common divisor of two *positive* integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}
