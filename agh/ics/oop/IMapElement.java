package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;

public interface IMapElement {

    public Image getImage() throws FileNotFoundException;

    public Vector2d getPos();
}
