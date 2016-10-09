package app.app.image;

import app.app.image.iterate.ImageElementVisitorInterface;

/**
 * Created by pcmagas on 5/10/2016.
 */
public interface ImageElement
{
    public abstract void draw(ImageElementVisitorInterface visitor);
}
