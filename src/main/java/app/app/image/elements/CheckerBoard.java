package app.app.image.elements;


import app.app.image.AbstractSizableImageElement;
import app.app.image.draw.ImageElementDrawingAlgorithmInterface;

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
     * X coordinate of the Checker's Element that need to be returned
     */
    private int itemToReturnX=0;

    /**
     * Y coordinate of the Checker's Element that need to be returned
     */
    private int itemToReturnY=0;


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
     * Method that Allows us to append a tile to the CheckerBoard
     */
    public void addElement(AbstractSizableImageElement e) throws Exception
    {
        if(!this.availableElements.contains(e))//We do not want to have duplicate Items
        {
            e.setParent(this);
            this.availableElements.add(e);
            this.initGrid();
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


    /**
     * Method that initializes the grid that need to Draw the tiles
     */
    private void initGrid()
    {
        for(int i=0;i<this.checkerGrid.length;i++)
        {
            for(int j=0;j<this.checkerGrid[i].length;j++)
            {
                AbstractSizableImageElement top=(i>0)?this.checkerGrid[i-1][j]:null;
                AbstractSizableImageElement previous=(j>0)?this.checkerGrid[i][j-1]:null;

                AbstractSizableImageElement currentTile=this.selectWhatToDraw(top,previous);

                this.checkerGrid[i][j]= currentTile;
            }
        }

        this.itemToReturnX=0;
        this.itemToReturnY=0;
    }


    /**
     * Method to retrieve the element that need to be Drawn
     * @return The current Element that need to be drawn
     */
    public AbstractSizableImageElement getElement()
    {
        AbstractSizableImageElement e= this.checkerGrid[this.itemToReturnY][this.itemToReturnX];

        if(this.itemToReturnX == this.checkerGrid[this.itemToReturnY].length)
        {
            this.itemToReturnY++;
            this.itemToReturnX=0;
        }
        else
        {
            this.itemToReturnX++;
        }


        return e;
    }


    /**
     * Checks if can draw the next Element
     * @return true if we can get another element
     */
    public boolean canGetElement()
    {
        return this.itemToReturnY+1 < this.checkerGrid.length && this.itemToReturnX+1 < this.checkerGrid[this.itemToReturnY+1].length;
    }


    /**
     * Checks id this class has element as available image element to draw
     * @param element The element we want to check if exists
     * @return
     */
    public boolean hasElement(AbstractSizableImageElement element)
    {
        return this.availableElements.contains(element);
    }


    @Override
    public boolean equals(Object other)
    {
        boolean ok = true;

        if(other instanceof CheckerBoard)
        {
            CheckerBoard otherToCompare = (CheckerBoard) other;

            for (AbstractSizableImageElement e : this.availableElements) {
                if (!otherToCompare.hasElement(e)) {
                    ok = false;
                    break;
                }
            }
        }
        else
        {
            ok=false;
        }
        return ok;
    }
}
