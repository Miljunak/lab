package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.map = new ArrayList<>();
        this.visualizer = new MapVisualizer(this);
    }
}
