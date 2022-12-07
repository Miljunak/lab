package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Grass implements IMapElement{
    private final Vector2d pos;

    public Grass(Vector2d pos){
        this.pos = pos;
    }
    @Override
    public String toString(){
        return "*";
    }
    @Override
    public Image getImage() throws FileNotFoundException {
        return new Image(new FileInputStream("src/main/resources/grass2.png"));
    }
    @Override
    public Vector2d getPos() { return pos; }
}
