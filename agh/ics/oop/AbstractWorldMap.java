package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{

    protected int width, height;
    protected ArrayList<Animal> map;
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
            for (Animal animol : map) {
                if (animol.getPos().equals(position)) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPos();
        for (Animal animol : map) {
            if (animol.getPos().equals(position)) return false;
        }
        map.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animol : map) {
            if (animol.getPos().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animol : map) {
            if (animol.getPos().equals(position)) return animol;
        }
        return null;
    }

    @Override
    public void removeAnimal(Vector2d position){
        for ( int i = 0 ; i < map.size() ; i++ ){
            if (map.get(i).getPos().equals(position)){
                map.remove(i);
                return;
            }
        }
    }
}
