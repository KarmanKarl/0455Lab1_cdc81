
/**
 * A counter that will roll over to the min
 * value when attempting to increase it beyond the maximum value and to the max 
 * value when attempting to decrease it below the min value
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter
{
    // PUT PRIVATE DATA FIELDS HERE

    private int min;
    private int max;
    private int value;
    private boolean rollover;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        // ADD CODE FOR THE CONSTRUCTOR

        this.min = 0;
        this.max = 2147483647;
        this.value = 0;
        this.rollover = false;

    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR

        if (min < max) 
        {
            this.min = min;
            this.max = max;
            this.value = min;
            this.rollover = false;
        } 

        if (min >= max) 
        {
            throw new CounterInitializationException("Mininmum Value is equal to or more than the maximum value, this is not allowed.");
        } 

    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    @Override
    public boolean equals(Object otherObject)
    {
        boolean result = false;
        if (otherObject instanceof Counter)
        {
            // YOUR CODE GOES HERE

            Counter test = new Counter(this.min,this.max);
            Counter otherTest = Counter.class.cast(otherObject);

            if (otherTest.min == test.min && otherTest.max == test.max && otherTest.value == test.value && otherTest.rollover == test.rollover) 
            {

                result = true;

            }
            
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER AND HANDLE ROLLOVER

        if (this.value != this.max) 
        {

            this.value += 1;
            this.rollover = false;

        } 
        else 
        {

            this.value = this.min;
            this.rollover = true;

        }

    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        // ADD CODE TO DECREASE THE VALUE OF THE COUNTER AND HANDLE ROLLOVER

        if (this.value != this.min) 
        {

            this.value -= 1;
            this.rollover = false;

        } 
        else 
        {

            this.value = this.max;
            this.rollover = true;

        }

    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return this.value;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return this.rollover;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        // MUST FOLLOW THE FOLLOWING FORMAT:
        //Counter: value=1 min=1 max=9 rolled over=false

        String status = "Counter: value=" + this.value + " min=" + this.min + " max=" + this.max + " rolled over=" + this.rollover;

        return status;		
    }
 
}
