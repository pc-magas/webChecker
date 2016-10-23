package app.app.image.draw.image;

import app.app.image.AbstractSizableImageElement;
import app.app.image.draw.ImageElementDrawingAlgorithm;
import app.app.image.elements.CheckerBoard;
import app.app.image.elements.Tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Created by pcmagas on 11/10/2016.
 */
public class JpegDrawingAlgorithm extends AbstractDrawingAlgorithm
{

    /**
     * Image that needs to Be Drawn
     */
    private BufferedImage imagetoDraw=null;

    /**
     * Class that helps up to draw the image
     */
    private Graphics2D g =null;


    /**
     *
     * @param width The Image's Width
     * @param height The Images' Height
     */
    public JpegDrawingAlgorithm(int width,int height)
    {
        this.imagetoDraw=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        this.g= imagetoDraw.createGraphics();
    }


    @Override
    final protected void tileDrawingAlgorithm(Tile t)
    {
        System.out.println("Tile "+t.toString());
    }

    @Override
    final protected void prepare(AbstractSizableImageElement element)
    {
        System.out.println("Preparint to draw: "+ element.toString());
    }

    @Override
    protected void afterDraw(AbstractSizableImageElement element) {

    }

    @Override
    public Object drawnCheckerBoard()
    {
        return null;
    }
}
