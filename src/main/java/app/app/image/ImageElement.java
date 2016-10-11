package app.app.image;

import app.app.image.draw.ImageElementDrawingAlgorithmInterface;

/**
 * Created by pcmagas on 5/10/2016.
 */
public interface ImageElement
{
    /**
     * Method that does all the drawing
     * @param visitor The class that implements the drawing function
     */
    public abstract void draw(ImageElementDrawingAlgorithmInterface visitor);
}
