package app.app.image.draw;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Created by pcmagas on 10/10/2016.
 * Defines a Plot Area we can Use for drawing an Image
 */
public class PlotArea
{

    /**
     * The size of the area
     */
    private Dimension size=null;

    /**
     * The top left point to Draw
     */
    private Point topLeft=null;

    /**
     * Constructor using a Point and a Dimention.
     * NOTE: it uses SHALLOW COPY of the Objects Point and Dimention
     * @param topLeft The Top Left point of the Plot Area we need to Draw
     * @param size The size of the plot area we need to Draw
     */
    public PlotArea(Point topLeft,Dimension size)
    {
        this.setTopLeft(topLeft);
        this.setSize(size);
    }

    /**
     * Constructor that Generates internally a Point and a Dimention
     *
     * @param topLeftX The value of the X axis for the Point of the top left corner.
     * @param topLeftY The value of the Y axis for the the Point of top left corner.
     * @param width The width of the selected plot area.
     * @param height The height of the selected plot area.
     */
    public PlotArea(int topLeftX,int topLeftY,int width, int height)
    {
        this(new Point(topLeftX,topLeftY),new Dimension(width, height));
    }

    /**
     * @return The top left corner of the plot area
     */
    public Point getTopLeft() {
        return topLeft;
    }

    /**
     * @param topLeft The top left corner of the plot area
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }


    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    /**
     * The plotArea that is next to this one at the right
     * @return A new instance of the plot area with the same size of this one but this one is at the right of this one
     */
    public PlotArea rightArea()
    {
        int newX=(int)this.topLeft.getX()+(int)this.size.getWidth();
        return this.movedArea(newX,(int)this.topLeft.getY());
    }


    /**
     * The plotArea that is next to this one at the right
     * @return A new instance of the plot area with the same size of this one but this one is right Below of this one
     */
    public PlotArea belowArea()
    {
        int newY=(int)this.topLeft.getY()+(int)this.size.getHeight();
        return this.movedArea((int)this.topLeft.getX(),newY);
    }


    /**
     * The area that is moved to Coordinates having x and y
     * @param x The coordinate of the X axis
     * @param y The coordinate of the Y axis
     * @return A new instance of the plot area with the same size of this one but with moved coordinates
     */
    public PlotArea movedArea(int x,int y)
    {
        Dimension sameArea= this.size.getSize();
        Point newPoint=new Point(x,y);

        return new PlotArea(newPoint,sameArea);
    }
}
