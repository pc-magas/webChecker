package app.app.image.draw.image;

import app.app.image.AbstractSizableImageElement;
import app.app.image.draw.ImageElementDrawingAlgorithmInterface;
import app.app.image.elements.CheckerBoard;
import app.app.image.elements.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pcmagas on 11/10/2016.
 */
public class JpegDrawingAlgorithm implements ImageElementDrawingAlgorithmInterface
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
//        this.imagetoDraw=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
//        this.g= imagetoDraw.createGraphics();
    }

    @Override
    public void applyDrawAlgorithm(AbstractSizableImageElement imageElement)
    {
        if(imageElement instanceof CheckerBoard)
        {
            this.checkerBoardDrawingAlgorithm((CheckerBoard) imageElement);
        }
        else if(imageElement instanceof Tile)
        {
            this.tileDrawingAlgorithm((Tile) imageElement);
        }
    }

    /**
     * Method For Drawing checkerboards
     * @param c
     */
    private void checkerBoardDrawingAlgorithm(CheckerBoard c)
    {
//        if(c.getParent()==null)
//        {
//
//        }
//        else
//        {
//
//        }

        System.out.println("Checker: \n"+c.toString());
    }

    /**
     * Method for Drawing tiles
     * @param t
     */
    private void tileDrawingAlgorithm(Tile t)
    {
        System.out.println("Tile:\n"+t.toString());
        //TODO: Implement Drawing for tile
    }
}
