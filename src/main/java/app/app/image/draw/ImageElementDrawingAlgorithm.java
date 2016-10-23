package app.app.image.draw;

import app.app.image.AbstractSizableImageElement;
/**
 * Created by pcmagas on 6/10/2016.
 * Interface that allows you to Implement the Drawing Algorithm
 */
public interface ImageElementDrawingAlgorithm
{

    /**
     * Method that draws the Element
     * @param imageElement
     */
    public void applyDrawAlgorithm(AbstractSizableImageElement imageElement);

    /**
     * Method that Exports the drawn checkerboard as an Object
     */
    public Object drawnCheckerBoard();
}
