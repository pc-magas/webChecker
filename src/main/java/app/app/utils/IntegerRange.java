package app.app.utils;

/**
 * Created by pcmagas on 10/10/2016.
 * @class Models a range of integers having Minimum value and Maximum Value
 */
public class IntegerRange
{
    /**
     * The current value for the range
     */
    private int value = 0;

    /**
     * The minimum value that this.value can have
     */
    private int min = 0;

    /**
     * Tme maximum value that this.value can have
     */
    private int max = 0;


    /**
     * @param min The minimum value
     * @param max The maximum value
     * @param val The current value
     * @throws IndexOutOfBoundsException when the value in tot between the range
     */
    public IntegerRange(int min, int max, int val) throws IndexOutOfBoundsException
    {

        this.setMin(min);
        this.setMax(max);
        this.setValue(val);
    }

    /**
     * @param min The minimum value
     * @param max The maximum value
     * @throws IndexOutOfBoundsException when the value in tot between the range
     */
    public IntegerRange(int min, int max) throws IndexOutOfBoundsException
    {
        this(min, max, min);
    }

    /**
     *
     * @param max The maximum value
     * @throws IndexOutOfBoundsException when the value in tot between the range
     */
    public IntegerRange(int max) throws IndexOutOfBoundsException
    {
        this(0,max);
    }

    /**
     * @return The current Value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Setter for a value
     * @param value The value we want to Insert
     * @throws IndexOutOfBoundsException when the value in tot between the range
     */
    public void setValue(int value) throws IndexOutOfBoundsException
    {
        if(this.fits(value))
        {
            this.value=value;
        }
        else
        {
            throw new IndexOutOfBoundsException("The value does not fit");
        }
    }


    /**
     * Increases the value by times (value=value+times)
     * @param times How many times the value will be increased
     * @throws IndexOutOfBoundsException when the value in tot between the range
     */
    public void incrementValue(int times) throws IndexOutOfBoundsException
    {
        this.setValue(this.getValue()+times);
    }

    /**
     * Increases the value by one (value=value+1)
     * @throws IndexOutOfBoundsException when the value in tot between the range
     */
    public void incrementValue() throws IndexOutOfBoundsException
    {
        this.incrementValue(1);
    }


    /**
     * Decreases the value by times (value=value-times)
     * @param times How much the value will be decremented
     * @throws IndexOutOfBoundsException
     */
    public void decrementValue(int times) throws IndexOutOfBoundsException
    {
        this.setValue(this.getValue()-times);
    }

    /**
     * Decrements value by 1 (value=value-1)
     * @throws IndexOutOfBoundsException
     */
    public void decrementValue() throws IndexOutOfBoundsException
    {
        this.decrementValue(1);
    }

    /**
     * @return The Range's Minimum value
     */
    public int getMin()
    {
        return this.min;
    }

    /**
     * @param min The Range's Minimum value
     */
    public void setMin(int min)
    {
        this.min=min;
    }

    /**
     * @return The Range's maximum value
     */
    public int getMax()
    {
        return this.max;
    }

    /**
     * @param max The Range's maximum value
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Check if value fits inside this Range
     * @param value The value we want to check if fits in this range
     *
     * @return
     */
    public boolean fits(int value)
    {
        return value>=this.getMin() && value<=this.getMax();
    }



    @Override
    public Object clone() throws IndexOutOfBoundsException
    {
        return (Object) new IntegerRange(this.getMin(),this.getMax(),this.getValue());
    }

}
