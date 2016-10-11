package app.app.image;

import app.app.image.draw.ImageElementDrawingAlgorithmInterface;

/**
 * Created by pcmagas on 9/10/2016.
 */
public abstract class AbstractSizableImageElement implements ImageElement
{

    /**
     *Parent element that tile is drawn
     */
    private AbstractSizableImageElement parent=null;

    /**
     * Sets the container for this tile
     * @param parent
     */
    public void setParent(AbstractSizableImageElement parent)
    {
        this.parent=parent;
    }

    /**
     * Gets the container for this tile
     * @return
     */
    public AbstractSizableImageElement getParent()
    {
        return this.parent;
    }

    @Override
    public void draw(ImageElementDrawingAlgorithmInterface visitor)
    {
        visitor.applyDrawAlgorithm(this);
    }
}
