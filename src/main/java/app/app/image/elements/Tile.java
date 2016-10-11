package app.app.image.elements;

import app.app.image.AbstractSizableImageElement;
import com.sun.corba.se.impl.orbutil.ObjectWriter;

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
     */
    public Tile(Color c)
    {
        this.setColor(c);
    }

    public Tile(Color c, AbstractSizableImageElement parent)
    {
        this(c);
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


    @Override
    public boolean equals(Object other)
    {

        if(other instanceof Tile)
        {
            Tile otherTile=(Tile) other;
            return this.getColor().equals(otherTile.getColor());
        }

        return false;
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
