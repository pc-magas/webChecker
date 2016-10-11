package app.app.image.iterate;

import app.app.image.AbstractSizableImageElement;
import app.app.image.draw.ImageElementDrawingAlgorithmInterface;
import app.app.image.elements.CheckerBoard;

import java.util.Iterator;

/**
 * Created by pcmagas on 6/10/2016.
 */
public class CheckerIterator implements Iterator<AbstractSizableImageElement>
{
    /**
     * The checkerBoard we want to iterate
     */
    private CheckerBoard checkerBoard =null;

    /**
     * The visitor we want to apply during the Iteration
     */
    private ImageElementDrawingAlgorithmInterface visitor=null;

    public CheckerIterator(CheckerBoard checkerBoard, ImageElementDrawingAlgorithmInterface visitor)
    {
        this.setCheckerBoard(checkerBoard);
        this.setVisitor(visitor);
    }


    /**
     * We set the Iterator's CheckerBoard.
     * @param c The checkerBoard we want to Iterate
     */
    public void setCheckerBoard(CheckerBoard c)
    {
        this.checkerBoard =c;
    }

    /**
     * @return The Iterator's CheckerBoard
     */
    public CheckerBoard getCheckerBoard()
    {
        return this.checkerBoard;
    }


    /**
     * We set a visitor for the Iterator
     * @param visitor The visitor for Iterator;
     */
    public void setVisitor(ImageElementDrawingAlgorithmInterface visitor)
    {
        this.visitor=visitor;
    }

    /**
     * @return The Iterator's visitor
     */
    public ImageElementDrawingAlgorithmInterface getVisitor()
    {
        return this.visitor;
    }

    @Override
    public AbstractSizableImageElement next() throws IndexOutOfBoundsException
    {
        if(this.hasNext())
        {
            AbstractSizableImageElement e=this.checkerBoard.getElement();

            this.visitor.applyDrawAlgorithm(e);

            return e;
        }
        else
        {
            throw new IndexOutOfBoundsException("There are no more Elements to be drawn.");
        }
    }

    @Override
    public boolean hasNext()
    {
       return this.checkerBoard.canGetElement();
    }

    @Override
    public void remove() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}
