package app.app.image.tiles;

import app.app.image.ImageElement;
import app.app.image.iterate.ImageElementVisitorInterface;

import java.awt.Color;

/**
 * Models a tile that is represented on a checker
 * Created by pcmagas on 5/10/2016.
 */
public class Tile implements ImageElement
{
    /**
     *Parent element that tile is drawn
     */
    private ImageElement parent=null;

    /**
     * The tile's size
     */
    private int size=0;

    /**
     * Tile's color
     */
    private Color color =null;

    /**
     *
     * @param c The tile's color
     * @param size The tile's width and height
     * @param parent A tile can be part of a larger Image, therefore we set a parent
     */
    public Tile(Color c, int size, ImageElement parent)
    {
        this.setColor(c);
        this.setParent(parent);
        this.setSize(size);
    }


    /**
     * Sets the container for this tile
     * @param parent
     */
    public void setParent(ImageElement parent)
    {
        this.parent=parent;
    }

    /**
     * Gets the container for this tile
     * @return
     */
    public ImageElement getParent()
    {
        return this.parent;
    }

    /**
     * Sets the color for the tile
     * @param c
     */
    public void setColor(Color c)
    {
        this.color =c;
    }

    /**
     * Returns the tile's color
     * @return
     */
    public Color getColor()
    {
        return this.color;
    }


    /**
     * Set the size for the tile
     * @param size
     */
    public void setSize(int size)
    {
        this.size=size;
    }

    /**
     * @return The Tile's size
     */
    public int getSize()
    {
        return this.size;
    }

    @Override
    public void draw(ImageElementVisitorInterface visitor)
    {
        visitor.visit(this);
    }

    /**
     *
     * @param other The other tile to
     * @return
     */
    public boolean equals(Tile other)
    {
        return this.sameSize(other) && this.getColor().equals(other.getColor());
    }

    /**
     * Compate if this tile has same sizt with antother one
     * @param other
     * @return
     */
    public boolean sameSize(Tile other)
    {
        return this.getSize()==other.getSize();
    }

    @Override
    public Tile clone()
    {
        return new Tile(this.getColor(),this.getSize(),this.getParent());
    }

    @Override
    public String toString()
    {
        return "Color: "+this.getColor().toString()+" Size: "+this.getSize();
    }
}
