package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected int width, height;
    protected HashMap<Vector2d, Animal> map;
    protected MapVisualizer visualizer;
    public Vector2d getLower() {
        return new Vector2d(0,0);
    }
    public Vector2d getHigher() {
        return new Vector2d(this.width - 1, this.height - 1);
    }

    public String toString(){
        return visualizer.draw(getLower(), getHigher());
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if ((position.x >= 0 && position.y >= 0) && (position.x < this.width && position.y < this.height)){
            return map.get(position) == null;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPos();
        if (map.get(position) != null) return false;
        animal.addObserver(this);
        map.put(position, animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) { return map.get(position) != null; }
    @Override
    public Object objectAt(Vector2d position) { return map.get(position); }
    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        Animal animal =  map.remove(oldPos);
        map.put(newPos, animal);
    }
}
