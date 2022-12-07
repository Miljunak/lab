package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Animal implements IMapElement {
    private MapDirection dir;
    private Vector2d pos;
    private final AbstractWorldMap map;
    private final ArrayList<IPositionChangeObserver> positionChangeObservers;

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.dir = MapDirection.NORTH;
        this.map = map;
        this.pos = initialPosition;
        this.positionChangeObservers = new ArrayList<>();
    }

    @Override
    public Vector2d getPos() {
        return pos;
    }

    @Override
    public String toString(){
        return Character.toString(dir.toString().charAt(0));
    }

    void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT) dir = dir.next();
        else if(direction == MoveDirection.LEFT) dir = dir.previous();
        else {
            int changer = direction == MoveDirection.FORWARD ? 1 : -1;
            Vector2d newPos = new Vector2d(pos.x, pos.y);
            switch (dir) {
                case EAST -> newPos.x += changer;
                case WEST -> newPos.x -= changer;
                case NORTH -> newPos.y += changer;
                default -> newPos.y -= changer;
            }
            if (map.canMoveTo(newPos)){
                this.positionChanged(this.pos, newPos);
                this.pos = newPos;
            }
        }
    }
    protected void addObserver(IPositionChangeObserver observer){
        if (observer instanceof MapBoundary) ((MapBoundary) observer).insertObject(this.pos);
        this.positionChangeObservers.add(observer);
    }
    protected void removeObserver(IPositionChangeObserver observer){
        this.positionChangeObservers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: positionChangeObservers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }

    @Override
    public Image getImage() throws FileNotFoundException {

        switch( dir ) {
            case NORTH -> {
                return new Image(new FileInputStream("src/main/resources/up.png"));
            }
            case EAST -> {
                return new Image(new FileInputStream("src/main/resources/right.png"));
            }
            case SOUTH -> {
                return new Image(new FileInputStream("src/main/resources/down.png"));
            }
            default -> {
                return new Image(new FileInputStream("src/main/resources/left.png"));
            }
        }
    }
}
