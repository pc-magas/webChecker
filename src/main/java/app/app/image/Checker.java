package app.app.image;


import app.app.image.iterate.ImageElementVisitorInterface;
import app.app.image.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by pcmagas on 5/10/2016.
 *
 * Methos that Implements a Checkerboard with multiple color tiles
 */
public class Checker implements ImageElement
{

    /**
     * The tiles that can be used to Draw the checker
     */
    private ArrayList<Tile> availableTiles=null;

    /**
     * The grid where the tiles are drawn
     */
    private Tile[][] checkerGrid=null;



    /**
     * The checker width
     */
    private int width=0;

    /**
     * The checker Height
     */
    private int height=0;

    private int tileSize=0;

    /**
     * Creates a new Checker
     * @param width the checker's width
     * @param height the checker's height
     */
    public Checker(int width, int height)
    {
        availableTiles= new ArrayList<Tile>();

        this.setHeight(height);
        this.setWidth(width);
    }

    /**
     * @param height The checker's height
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
     * Method that Allows us to append a tile to the Checker
     */
    public void addTile(Tile t) throws Exception
    {
        if(this.tileSize >0 && t.getSize()!= this.tileSize)
        {
            throw new Exception("The tile does not have the same size with the orthers");
        }
        else if(!this.availableTiles.contains(t))
        {
            this.availableTiles.add(t);
            this.tileSize=t.getSize();
        }
    }


    /**
     * Method that initializes the grid for the checker
     */
    private void initGrid()
    {
        if(this.checkerGrid==null)
        {
            int width = this.width/this.tileSize;
            int height = this.height/this.tileSize;

            this.checkerGrid=new Tile[height][width];
        }
    }

    /**
     * Method that selects a tile during the grid generation
     * @param top The tile that is on top of the current tile
     * @param previous The tile that is on previously from the current tile
     *
     * @return The correctly selected tile
     */
    private Tile selectTile(Tile top,Tile previous)
    {
        ArrayList<Tile> tilesToSelect= new ArrayList<Tile>();

        for(Tile t : this.availableTiles)
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
        this.initGrid();

        for(int i=0;i<this.checkerGrid.length;i++)
        {
            for(int j=0;j<this.checkerGrid[i].length;j++)
            {
                Tile top=(i>0)?this.checkerGrid[i-1][j]:null;
                Tile previous=(j>0)?this.checkerGrid[i][j-1]:null;

                Tile currentTile=this.selectTile(top,previous);
                this.checkerGrid[i][j]= currentTile;

                currentTile.draw(visitor);
            }
        }

    }

}
