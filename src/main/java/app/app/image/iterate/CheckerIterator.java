package app.app.image.iterate;

import app.app.image.elements.CheckerBoard;

import java.util.Iterator;

/**
 * Created by pcmagas on 6/10/2016.
 */
public class CheckerIterator implements Iterator<Boolean>
{
    /**
     * The checkerBoard we want to iterate
     */
    private CheckerBoard checkerBoard =null;

    /**
     * The visitor we want to apply during the Iteration
     */
    private ImageElementVisitorInterface visitor=null;

    public CheckerIterator(CheckerBoard checkerBoard, ImageElementVisitorInterface visitor)
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
    public void setVisitor(ImageElementVisitorInterface visitor)
    {
        this.visitor=visitor;
    }

    /**
     * @return The Iterator's visitor
     */
    public ImageElementVisitorInterface getVisitor()
    {
        return this.visitor;
    }

    @Override
    public Boolean next()
    {
       checkerBoard.draw(this.visitor);
       return new Boolean(true);
    }

    @Override
    public boolean hasNext()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
