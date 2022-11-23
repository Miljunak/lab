package agh.ics.oop;

import java.util.ArrayList;

public class Animal {
    private MapDirection dir;
    private Vector2d pos;
    private AbstractWorldMap map;
    private  ArrayList<IPositionChangeObserver> positionChangeObservers;

    public Animal(){
        this.dir = MapDirection.NORTH;
        this.pos = new Vector2d(2,2);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.dir = MapDirection.NORTH;
        this.map = map;
        this.pos = initialPosition;
        this.positionChangeObservers = new ArrayList<>();
    }

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
                //System.out.println(positionChangeObservers.size());
                this.positionChanged(this.pos, newPos);
                this.pos = newPos;
            }
        }
    }
    protected void addObserver(IPositionChangeObserver observer){
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
}
