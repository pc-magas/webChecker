package app.app.image.elements;

import app.app.image.AbstractSizableImageElement;

import java.awt.Color;

/**
 * Models a tile that is represented on a checker
 * Created by pcmagas on 5/10/2016.
 */
public class Tile  extends AbstractSizableImageElement
{
    /**
     * Tile's color
     */
    private Color color =null;

    /**
     * @param c The tile's color
     * @param parent A tile can be part of a larger Image, therefore we set a parent
     */
    public Tile(Color c, AbstractSizableImageElement parent)
    {
        this.setColor(c);
        this.setParent(parent);
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
     *
     * @param other The other tile to
     * @return
     */
    public boolean equals(Tile other)
    {
        return this.getColor().equals(other.getColor());
    }


    @Override
    public Tile clone()
    {
        return new Tile(this.getColor(),this.getParent());
    }

    @Override
    public String toString()
    {
        return "Color: "+this.getColor().toString();
    }
}
