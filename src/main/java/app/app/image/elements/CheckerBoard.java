package app.app.image.elements;


import app.app.image.AbstractSizableImageElement;
import app.app.image.iterate.ImageElementVisitorInterface;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by pcmagas on 5/10/2016.
 *
 * Methos that Implements a Checkerboard with multiple color elements
 */
public class CheckerBoard  extends AbstractSizableImageElement
{
    /**
     * The elements that can be used to Draw the checker
     */
    private ArrayList<AbstractSizableImageElement> availableElements =null;

    /**
     * The grid where the elements are drawn
     */
    private AbstractSizableImageElement[][] checkerGrid=null;

    /**
     * How many Image Elements will have on Image's width
     */
    private int width=0;

    /**
     * How many Image elements will have on Image's height
     */
    private int height=0;


    /**
     * Creates a new CheckerBoard
     * @param width the checker's width
     * @param height the checker's height
     */
    public CheckerBoard(int width, int height)
    {
        this.setWidth(width);
        this.setHeight(height);
        this.availableElements = new ArrayList<AbstractSizableImageElement>();

        this.checkerGrid=new AbstractSizableImageElement[this.getHeight()][this.getWidth()];
    }


    /**
     * @param height The checker's elements
     */
    public void setHeight(int height)
    {
        this.height=height;
    }

    /**
     * @return The checker's height
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Seth the tile width
     * @param width
     */
    public void setWidth(int width)
    {
        this.width=width;
    }

    /**
     * Returns how wide is the tile
     * @return
     */
    public int getWidth()
    {
        return this.width;
    }


    /**
     * Determine wether the shape is square or not
     * @return
     */
    public boolean isSquare()
    {
        return this.getHeight()==this.getWidth();
    }

    /**
     * Method that Allows us to append a tile to the CheckerBoard
     */
    public void addElement(AbstractSizableImageElement e) throws Exception
    {
        if(!this.availableElements.contains(e))//We do not want to have duplicate Items
        {
            e.setParent(this);
            this.availableElements.add(e);
        }
    }

    /**
     * Method that selects a the correct ImageElement during the drawing
     * @param top The tile that is on top of the current tile
     * @param previous The tile that is on previously from the current tile
     *
     * @return The correctly selected tile
     */
    private AbstractSizableImageElement selectWhatToDraw(AbstractSizableImageElement top, AbstractSizableImageElement previous)
    {
        ArrayList<AbstractSizableImageElement> tilesToSelect= new ArrayList<AbstractSizableImageElement>();

        for(AbstractSizableImageElement t : this.availableElements)
        {
            if( ( top!= null && t.equals(top) )|| ( previous != null && t.equals(previous)) )
            {
                continue;
            }

            tilesToSelect.add(t);
        }

        //Shuffle the list
        Collections.shuffle(tilesToSelect);
        //And return the first item
        return tilesToSelect.get(0);
    }

    @Override
    public void draw(ImageElementVisitorInterface visitor)
    {
        for(int i=0;i<this.checkerGrid.length;i++)
        {
            for(int j=0;j<this.checkerGrid[i].length;j++)
            {
                AbstractSizableImageElement top=(i>0)?this.checkerGrid[i-1][j]:null;
                AbstractSizableImageElement previous=(j>0)?this.checkerGrid[i][j-1]:null;

                AbstractSizableImageElement currentTile=this.selectWhatToDraw(top,previous);

                this.checkerGrid[i][j]= currentTile;

                currentTile.draw(visitor);
            }
        }
    }

    public boolean hasElement(AbstractSizableImageElement element)
    {
        return this.availableElements.contains(element);
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean equals(CheckerBoard other)
    {
        boolean ok=true;

        for(AbstractSizableImageElement e : this.availableElements)
        {
            if(!other.hasElement(e))
            {
                ok=false;
                break;
            }
        }

        return ok;
    }
}
