package app.app.image.draw.image;

import app.app.image.AbstractSizableImageElement;
import app.app.image.draw.ImageElementDrawingAlgorithm;
import app.app.image.elements.CheckerBoard;
import app.app.image.elements.Tile;

/**
 * Created by pcmagas on 23/10/2016.
 */
abstract class AbstractDrawingAlgorithm  implements ImageElementDrawingAlgorithm
{

    @Override
    final public void applyDrawAlgorithm(AbstractSizableImageElement imageElement)
    {
        this.prepare(imageElement);

        if(imageElement instanceof CheckerBoard)
        {
            this.checkerBoardDrawingAlgorithm((CheckerBoard) imageElement);
        }
        else if(imageElement instanceof Tile)
        {
            this.tileDrawingAlgorithm((Tile) imageElement);
        }

        this.afterDraw(imageElement);
    }

    /**
     * Method For Drawing checkerboards
     * @param c
     */
    private void checkerBoardDrawingAlgorithm(CheckerBoard c)
    {
        for(AbstractSizableImageElement element : c)
        {
            this.applyDrawAlgorithm(element);
        }
    }

    /**
     * Method for Drawing tiles
     * @param t
     */
    abstract protected void tileDrawingAlgorithm(Tile t);

    /**
     * Prepare for drawing
     * @param element The element we need to prepare in order to
     */
    abstract protected void prepare(AbstractSizableImageElement element);

    /**
     * Method that is called when
     * @param element The element that has already been drawn.
     */
    abstract protected void afterDraw(AbstractSizableImageElement element);
}
